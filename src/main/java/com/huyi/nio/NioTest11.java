package com.huyi.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;


/**
*锁
 */
public class NioTest11 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile =new RandomAccessFile("NioTest10.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        FileLock lock = channel.lock(3,6,true);
        System.out.println("valid :" +lock.isValid());
        System.out.println("lock type:" +lock.isShared());
        lock.release();
        randomAccessFile.close();
    }




}
