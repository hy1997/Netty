package com.huyi.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Oldserver {
    public static void main(String[] args) throws  Exception{
        ServerSocket serverSocket =new ServerSocket(8899);
        while (true){
            Socket socket =serverSocket.accept();
            DataInputStream  dataInputStream =new DataInputStream(socket.getInputStream());
            try{
                byte[]  byteArray=new byte[4096];
                while (true){
                    dataInputStream.read(byteArray);


                }



            }catch (Exception e){

            }






        }




    }

}
