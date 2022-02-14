package com.huminxi.channel;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * https://javadoop.com/post/java-nio
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/11 19:35
 */
public class FileChannelExample {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/10007614/data.txt";
        read(filename);
        write(filename);
    }

    private static int read(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filename));
        java.nio.channels.FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int num = channel.read(buffer);
        System.out.println(num);
        return num;
    }

    private static int write(String filename) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(new File("/Users/10007614/data.txt"));
        java.nio.channels.FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("随机写入一些内容到 buffer 中".getBytes());
        //切换为读模式
        buffer.flip();
        int num = 0;
        while (buffer.hasRemaining()) {
            num += channel.write(buffer);
        }
        System.out.println(num);
        return num;
    }
}
