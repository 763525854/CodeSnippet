package com.rhyme.分布式消息中间件实践.chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//消息客户端
public class MQClient {
	// 生产消息
	public static void produce(String message) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(message);
		out.flush();
	}

	public static String consume() throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println("CONSUME");
		out.flush();
		String message = in.readLine();
		return message;
	}
}
