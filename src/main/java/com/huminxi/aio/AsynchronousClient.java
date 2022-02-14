package com.huminxi.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 16:17
 */
public class AsynchronousClient {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        //来个 Future 形式的。
        Future<?> future = client.connect(new InetSocketAddress(8080));
        //阻塞一下，等待连接成功。
        future.get();
        Attachment att = new Attachment();
        att.setClient(client);
        att.setReadMode(false);
        att.setBuffer(ByteBuffer.allocate(2048));
        byte[] data = "I am robot!".getBytes();
        att.getBuffer().put(data);
        att.getBuffer().flip();
        //异步发送数据到服务端。
        client.write(att.getBuffer(), att, new ClientHandler());
        //这里休息一下再退出，给出足够的时间处理数据。
        Thread.sleep(2000);
    }
}
