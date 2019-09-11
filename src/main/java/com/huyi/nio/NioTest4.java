package com.huyi.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest4 {
    public static void main(String[] args) {
        // 分配内存大小为10的缓存区
        IntBuffer buffer = IntBuffer.allocate(10);
        System.out.println("capacity:" + buffer.capacity());//10
        for (int i = 0; i < 5; ++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        System.out.println("before flip limit:" + buffer.limit());//10
        buffer.flip();
        System.out.println("after flip limit:" + buffer.limit());//5
        System.out.println("enter while loop");
        while (buffer.hasRemaining()) {
            System.out.println("position:" + buffer.position());
            System.out.println("limit:" + buffer.limit());//5
            System.out.println("capacity:" + buffer.capacity());//10
            System.out.println("元素:" + buffer.get());
        }
    }
}
