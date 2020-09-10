package com.xuxincheng.boot;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        new UdpClient().start();
    }

    // 目的端口号
    private static final int DEST_PORT = 9999;
    // 目的IP
    private static final String DEST_IP = "127.0.0.1";
    // 数据报长度
    private static final int DATA_LEN = 4096;
    private byte[] recvBuffer = new byte[DATA_LEN];

    // 用于接收数据
    private DatagramPacket in = new DatagramPacket(recvBuffer, recvBuffer.length);
    // 用于发送数据
    private DatagramPacket out = null;

    public void start() {
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress ip = InetAddress.getByName(DEST_IP);
            out = new DatagramPacket(new byte[0], 0, ip, DEST_PORT);

            Scanner sc = new Scanner(System.in);
           System.out.println("请输入数据：");

            String word = null;
            byte[] sendBuffer = null;
            while (sc.hasNextLine()) {
                word = sc.nextLine();

                if ("exit".equals(word)) {
                    break;
                }

                sendBuffer = word.getBytes();
                out.setData(sendBuffer);
                socket.send(out);

                socket.receive(in);
                System.out.println(new String(recvBuffer, 0, in.getLength()));
                System.out.println("请输入数据：");
            }

            System.out.println("客户端退出...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
