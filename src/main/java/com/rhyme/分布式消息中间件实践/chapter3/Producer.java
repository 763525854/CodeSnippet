package com.rhyme.分布式消息中间件实践.chapter3;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

//rabbitmq生产者
public class Producer {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setHost("localhost");
		factory.setVirtualHost("/");
		Connection coon=factory.newConnection();
		Channel channel=coon.createChannel();
		String exchangeName="hello-exchange";
		channel.exchangeDeclare(exchangeName, "direct",true);
		String routingKey="testRoutingKey";
		byte[] messageBodyBytes="quit".getBytes();
		channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
		channel.close();
		coon.close();
	}
}
