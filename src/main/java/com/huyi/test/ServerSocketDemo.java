package com.huyi.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 连接的线程太多！
 */
public class ServerSocketDemo implements  Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket =new ServerSocket(8899);
            while (true){
                 new Thread(new Handler(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static  class  Handler implements  Runnable{
        Socket s;
        Handler(Socket s){
            this.s=s;
        }
        @Override
        public void run() {
            try {
                //数据的操作
                s.getInputStream();



            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
