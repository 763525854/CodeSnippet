package com.rhyme.分布式消息中间件实践.chapter2;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//消息消费者
public class QueueConsumer {
	public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
		try {
			Connection connection=connectionFactory.createConnection();
			connection.start();
			final Session session=connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Queue myTestQueue=session.createQueue("activemq-queue-test1");
			MessageConsumer consumer=session.createConsumer(myTestQueue);
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message message) {
					try {
						TextMessage textMessage=(TextMessage) message;
						System.out.println(textMessage.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						session.commit();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			Thread.sleep(100*1000);
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
