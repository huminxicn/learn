package com.huminxi.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 14:28
 */
public class SocketHandler implements Runnable {
    private SocketChannel socketChannel;

    public SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            //将请求数据读入 buffer 中。
            int num;
            while ((num = socketChannel.read(buffer)) > 0) {
                //读取 buffer 内容之前先 flip 一下。
                buffer.flip();
                //提前 buffer 中的数据。
                byte[] bytes = new byte[num];
                buffer.get(bytes);
                String read = new String(bytes, "UTF-8");
                System.out.println("收到请求：" + read);
                //回应客户端
                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + read).getBytes());
                socketChannel.write(writeBuffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
