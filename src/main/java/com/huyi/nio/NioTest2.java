package com.huyi.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream  fileInputStream =new FileInputStream ("messag");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer =ByteBuffer.allocate(512);
        channel.read(byteBuffer);
        byteBuffer.flip();

        while (byteBuffer.remaining()>0){
            byte b = byteBuffer.get();
            System.out.println((char)b);
        }

        fileInputStream.close();
    }
}
