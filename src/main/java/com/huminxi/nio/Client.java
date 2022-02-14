package com.huminxi.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 15:00
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        //发送请求
        ByteBuffer writeBuffer = ByteBuffer.wrap("12345678".getBytes());
        socketChannel.write(writeBuffer);
        //读取响应
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            byte[] read = new byte[num];
            readBuffer.get(read);
            String result = new String(read, "UTF-8");
            System.out.println("返回值：" + result);
        }
    }
}
