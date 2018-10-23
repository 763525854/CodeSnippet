package com.rhyme.分布式消息中间件实践.chapter2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//消息生产者
public class QueueProducer {
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Queue myTestQueue = session.createQueue("activemq-queue-test1");
			MessageProducer producer = session.createProducer(myTestQueue);
			TextMessage message = session.createTextMessage("测试点对点的一条消息");
			producer.send(message);
			session.commit();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
