package com.rhyme.分布式消息中间件实践.chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//BrokerServer对外提供Broker类的服务
@SuppressWarnings("resource")
public class BrokerServer implements Runnable {

	public static int SERVICE_PORT = 9999;

	private Socket socket;

	public BrokerServer(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String str = in.readLine();
				if (str == null) {
					continue;
				}
				System.out.println("接收到原始数据:" + str);
				if (str.equals("CONSUME")) {// CONSUME表示要消费一条信息
					// 从消息队列中消费一条信息
					String message = Broker.consume();
					out.println(message);
					out.flush();
				} else {
					// 其他情况表示生产消息放到消息队列中
					Broker.produce(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(SERVICE_PORT);
		while (true) {
			BrokerServer brokerServer = new BrokerServer(server.accept());
			new Thread(brokerServer).start();

		}
	}

}
