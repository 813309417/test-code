package com.xuxincheng.boot;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
public class UdpServer {
    public static void main(String[] args) {
        new UdpServer().start();
    }
    // 绑定端口号
    private static final int PORT = 9999;
    // 设置数据报大小
    private static final int DATA_LEN = 4096;
    private byte[] recvBuffer = new byte[DATA_LEN];

    // 用于接收数据
    private DatagramPacket in = new DatagramPacket(recvBuffer, recvBuffer.length);
    // 用于发送数据
    private DatagramPacket out = null;

    public void start() {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            SocketAddress address = null;
            String word = null;
            byte[] sendBuffer = null;

            System.out.println("服务端启动了...");

            while (true) {
                socket.receive(in);
                address = in.getSocketAddress();
                //处理以下bug添加的代码
                byte[] ne = new byte[in.getLength()];
                System.arraycopy(in.getData(), 0, ne, 0, in.getLength());
                recvBuffer = ne;
                //原来文章里的代码  此处会出现bug具体为输入999万后再输入1  会变成只替代第一位  变成199
               // recvBuffer = in.getData();
                word = new String(recvBuffer).trim();
                System.out.println("客户端：" + word);

                if ("down".equals(word)) {
                    sendBuffer = "服务端已关闭，请重试！".getBytes();
                    out = new DatagramPacket(sendBuffer, sendBuffer.length, address);
                    socket.send(out);
                    break;
                }

                sendBuffer = ("您输入的内容是：" + word).getBytes();
                out = new DatagramPacket(sendBuffer, sendBuffer.length, address);
                socket.send(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
