package com.huyi.nio;

import java.io.BufferedReader;
import java.nio.ByteBuffer;


/**
 * slice 与员原有的Buffer共享一个数组
 */
public class NioTest7 {
    public static void main(String[] args) {
    ByteBuffer buffer =ByteBuffer.allocate(10);
        for (int i = 0; i <buffer.capacity() ; i++) {
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(6);
        ByteBuffer  sliceBuffer=buffer.slice();
        for (int i = 0; i <sliceBuffer.capacity() ; i++) {
            byte b=sliceBuffer.get(i);
            b*=2;
            sliceBuffer.put(i,b);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }


    }


}
