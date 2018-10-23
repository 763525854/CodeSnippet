package com.rhyme.分布式消息中间件实践.chapter3;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Consumer {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setHost("localhost");
		factory.setVirtualHost("/");
		Connection coon = factory.newConnection();
		final Channel channel = coon.createChannel();
		String exchangeName = "hello-exchange";
		channel.exchangeDeclare(exchangeName, "direct", true);
		String queueName = channel.queueDeclare().getQueue();
		String routingKey = "testRoutingKey";
		channel.queueBind(queueName, exchangeName, routingKey);
		while (true) {
			boolean autoAck = false;
			String consumeTag = "";
			channel.basicConsume(queueName, autoAck, consumeTag, new DefaultConsumer(channel) {

				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String routingKey = envelope.getRoutingKey();
					String contentType = properties.getContentType();
					System.out.println("消费的路由键:" + routingKey);
					System.out.println("消费的路由键:" + contentType);
					long delivertTag = envelope.getDeliveryTag();
					channel.basicAck(delivertTag, false);
					System.out.println("消费的消息体内容");
					String bodyStr = new String(body, "UTF-8");
					System.out.println(bodyStr);
				}
			});
		}
	}
}
