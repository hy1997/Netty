package com.huyi.nio;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


/**
 *
 */
public class NioTest14 {

    public static void main(String[] args) throws Exception {
        String inputFile="NioTest14_In.txt";
        String outputFile="NioTest14_out.txt";
        RandomAccessFile inputRandomAccessFile =new RandomAccessFile(inputFile,"r");

    }
}
