package com.huyi.nio;

import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;


/**
*关于Buffer的Scattering 与 Gathering
 */
public class NioTest12 {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(inetSocketAddress);
        int messageLengths = 2 + 3 + 4;

        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[0] = ByteBuffer.allocate(3);
        byteBuffers[0] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLengths) {
                Long r = socketChannel.read(byteBuffers);
                bytesRead += r;

                Arrays.asList(byteBuffers).stream().map(byteBuffer -> "position: " + byteBuffer.position() + ",limit： " + byteBuffer.limit()).
                        forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
        long bytesWritten = 0;
        while (bytesWritten < messageLengths) {
            long r = socketChannel.write(byteBuffers);
            bytesWritten += r;
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
        }
        }

    }
}
