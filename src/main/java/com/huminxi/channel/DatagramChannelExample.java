package com.huminxi.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 10:58
 */
public class DatagramChannelExample {
    public static void main(String[] args) throws IOException {
        listen();
        send();
    }

    public static void listen() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9090));
        ByteBuffer buffer = ByteBuffer.allocate(48);
        datagramChannel.receive(buffer);
    }

    public static void send() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9090));
        String newData = "new String to write to file." + System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put(newData.getBytes());
        buffer.flip();
        int send = datagramChannel.send(buffer, new InetSocketAddress("jeko.com", 80));
    }
}
