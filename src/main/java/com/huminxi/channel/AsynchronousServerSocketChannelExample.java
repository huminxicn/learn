package com.huminxi.channel;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 15:44
 */
public class AsynchronousServerSocketChannelExample {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open().bind(null);

    }
}
