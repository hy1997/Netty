package com.huyi.nio;

import java.nio.ByteBuffer;

public class NioTest6 {
    public static void main(String[] args) {
    ByteBuffer buffer =ByteBuffer.allocate(64);
        buffer.putInt(15);
        buffer.putLong(500000L);
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
    }


}
