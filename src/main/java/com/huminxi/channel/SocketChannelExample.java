package com.huminxi.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 10:50
 */
public class SocketChannelExample {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("https://www.javadoop.com", 443));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer);
        //写入数据到网络连接中
        while (buffer.hasRemaining()) {
            socketChannel.write(buffer);
        }
    }
}
