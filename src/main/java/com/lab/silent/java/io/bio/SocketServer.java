package com.lab.silent.java.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        //监听9000端口
        ServerSocket serverSocket = new ServerSocket(9000);
        //等待链接
        while(true){
            System.out.println("等待链接...");
            //阻塞方法,telnet localhost 9000 端口连接
            Socket  client = serverSocket.accept();
            System.out.println("已链接...");
            //可以使用线程异步处理,或者使用线程池来提高连接数量,但是无法解决,getInputStream().read多个线程全部被占用的情况
            new Thread(){
                @Override
                public void run() {
                    try {
                        handler(client);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();

        }
    }

    private static void handler(Socket client) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read...");
        //直接使用send 命令发送信息
        int read = client.getInputStream().read(bytes);
        System.out.println("read完成...");
        String params = "";
        if(read != -1){
            params = new String(bytes,0,read);
            System.out.println("接收到客户端数据:"+params);
        }
        System.out.println("连接完成");
        String str = "已经收到请求:请求入参为:"+params;
        client.getOutputStream().write(str.getBytes());

    }
}
