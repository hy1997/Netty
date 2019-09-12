package com.huyi.nio;

import java.nio.ByteBuffer;


/**
 * 只读buffer 我们可以随时建一个普通Buffer调用asReadOnlyBuffer方法放回一个只读Buffer
 * 但不能将一个只读Buffer转换为读写Buffer
 */
public class NioTest8{

    public static void main(String[] args) {
        ByteBuffer buffer =ByteBuffer.allocate(10);
        System.out.println(buffer.getClass());
        for (int i = 0; i <buffer.capacity() ; i++) {
            buffer.put((byte)i);
        }
        //生成一个只读Buffer
        ByteBuffer  readBuffer=buffer.asReadOnlyBuffer();

    }




}
