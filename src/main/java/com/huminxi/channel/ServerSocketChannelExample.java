package com.huminxi.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ServerSocketChannel 不和 Buffer 打交道了，因为它并不实际处理数据，它一旦接收到请求后，实例化 SocketChannel，之后在这个连接通道上的数据传递它就不管了，因为它需要继续监听端口，等待下一个连接。。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/14 10:53
 */
public class ServerSocketChannelExample {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            //一旦有一个 TCP 连接进来，就对应创建一个 SocketChannel 进行处理。
            SocketChannel socketChannel = serverSocketChannel.accept();
        }
    }
}
