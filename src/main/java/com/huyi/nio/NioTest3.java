package com.huyi.nio;

import com.sun.javafx.image.impl.ByteRgb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream  fileOutputStream =new FileOutputStream("message.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] message="hello word  所发生的 是；六十九是".getBytes();
        for (int i=0;i<message.length;i++) {
            byteBuffer.put(message[i]);
        }
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
