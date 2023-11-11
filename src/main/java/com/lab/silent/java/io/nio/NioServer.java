package com.lab.silent.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * jdk 1.4之后的新功能
 */
public class NioServer {
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //创建NIO
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        //绑定端口
        serverSocket.bind(new InetSocketAddress(9000));
        //设置为非阻塞
        serverSocket.configureBlocking(false);
        while (true){
            //NIO的非阻塞模式的accept并不会阻塞,调用了linux的accept函数
            SocketChannel socketChannel = serverSocket.accept();
            if(socketChannel != null){
                System.out.println("连接成功");
                //设置socketChannel也为非阻塞
                socketChannel.configureBlocking(false);
                //将当前链接保存在list中,用于后续的其他操作
                channelList.add(socketChannel);
            }
            Iterator<SocketChannel> iterator = channelList.listIterator();
            //这里就是浪费性能的地方,如果1w个连接,只有1个send了数据,那这里遍历了1w次,才读取到对应的连接
            //是否可以针对 channelList 做一些优化,尽量减少循环次数,或者没有数据send的时候,直接阻塞起来,避免性能浪费呢 --> NioSelectorServer
            while (iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(6);
                //socketChannel已经设置为了非阻塞,不会阻塞
                int len = sc.read(byteBuffer);
                String params = "";
                if(len>0){
                    params = new String(byteBuffer.array());
                    System.out.println("接收到消息:"+params);
                }else{
                    iterator.remove();
                    System.out.println("客服端断开连接!");

                }

            }
        }
    }
}
