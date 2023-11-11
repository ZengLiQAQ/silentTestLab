package com.lab.silent.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NioSelectorServer{
        static List<SocketChannel> channelList = new ArrayList<>();

        public static void main(String[] args) throws IOException {
            //创建NIO
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            //绑定端口
            serverSocket.bind(new InetSocketAddress(9000));
            //设置为非阻塞
            serverSocket.configureBlocking(false);
            //打开selector 处理 channel,即创建: epoll
            Selector selector = Selector.open();
            //将 serverSocket 注册到 selector 上,同时委托 selector 监听客户端对 9000端口的 accept 连接事件
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务启动成功");
            while (true){
                //利用 selector 阻塞来等待需要处理的事件发生(让出cpu)
                selector.select();

                //获取selector 中 所有注册的全部事件的 SelectionKey 实例
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                //遍历所有的注册事件对注册事件进行处理
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //如果是OP_ACCEPT事件,则进行连接获取和事件注册
                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel sc =  server.accept();
                        sc.configureBlocking(false);
                        //同样注册读事件
                        sc.register(selector,SelectionKey.OP_READ);
                        System.out.println("客户端连接成功");
                     }else if(key.isReadable()){
                        //如果是OP_READ事件,则进行读取与打印
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
                        //socketChannel已经设置为了非阻塞,不会阻塞
                        int len = sc.read(byteBuffer);
                        String params = "";
                        if(len>0){
                            params = new String(byteBuffer.array());
                            System.out.println("接收到消息:"+params);
                        }else if(len == -1){
                            //如果监听到了读事件,却没有数据,则说明这里已经与客户端断开连接,关闭socket
                            System.out.println("客户端断开连接");
                            sc.close();
                        }
                    }
                    //从事件集合中删除本次处理的key,避免下次select重复处理
                    iterator.remove();
                }
            }
        }
    }


