package com.huminxi.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 16:00
 */
public class ServerHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer result, Attachment att) {
        if (att.isReadMode()) {
            //读取来自客户端的数据。
            ByteBuffer buffer = att.getBuffer();
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(buffer.array()).trim();
            System.out.println("收到来自客户端的数据：" + msg);
            //响应客户端请求，返回数据
            buffer.clear();
            buffer.put("Response from server!".getBytes(StandardCharsets.UTF_8));
            att.setReadMode(false);
            buffer.flip();
            //写数据到客户端也是异步
            att.getClient().write(buffer, att, this);
        } else {
            // 到这里，说明往客户端写数据也结束了，有以下两种选择:
            // 1. 继续等待客户端发送新的数据过来
//            att.setReadMode(true);
//            att.getBuffer().clear();
//            att.getClient().read(att.getBuffer(), att, this);
            // 2. 既然服务端已经返回数据给客户端，断开这次的连接
            try {
                att.getClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("failed--断开连接。");
    }
}
