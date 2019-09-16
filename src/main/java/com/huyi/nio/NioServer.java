package com.huyi.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;


/**
 *
 */
public class NioServer {

    private   static Map<String ,SocketChannel > clientMap = new HashMap<String,SocketChannel>();
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        /**将serverSocketChannel注册到Selecto   注册 的是连接事件r**/
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try {
                //监听的事件发生后才会生效;
                selector.select();
                //获取
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                 final  SocketChannel client;


                    try {
                        if(selectionKey.isAcceptable()){
                            //获取到触发事件的channel对象
                            ServerSocketChannel  server =(ServerSocketChannel)selectionKey.channel();
                            //等待连接
                            client=server.accept();
                            client.configureBlocking(false);
                            //建立连接后在注册到selector上  注意： 监听的事件不一样了
                            client.register(selector,SelectionKey.OP_READ);
                            String key="["+ UUID.randomUUID().toString()+"]";
                            clientMap.put(key,client);
                        }else if(selectionKey.isReadable()){
                            //注册的是OP_READ
                              client =(SocketChannel)selectionKey.channel();
                            ByteBuffer  readBuffer =ByteBuffer.allocate(1024);
                            int cont = client.read(readBuffer);
                            if(cont>0){
                                readBuffer.flip();
                                Charset charset =Charset.forName("utf-8");
                                String s = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println(client+":" +s);

                                String sendKey= null;
                                for (Map.Entry<String,SocketChannel> entry: clientMap.entrySet()) {
                                    if(client==entry.getValue()){
                                         sendKey = entry.getKey();

                                    }
                                }
                                for (Map.Entry<String,SocketChannel> entry: clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
                                    byteBuffer.put((selectionKey+" : "+s).getBytes());
                                    byteBuffer.flip();
                                    value.write(byteBuffer);
                                }
                            }

                        }
                    } catch (Exception e) {

                    }
                });
                clientMap.clear();

            } catch (Exception e) {

            }


        }


    }
}
