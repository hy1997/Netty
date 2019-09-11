package com.huyi.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer  buffer = IntBuffer.allocate(10);
        System.out.println(buffer.capacity());
        for (int i=0;i<buffer.capacity();i++){
            int randomNumber =new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        //状态的翻转
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }



    }
}
