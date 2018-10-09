package com.rhyme.分布式消息中间件实践;

//生产消息
public class ProduceClient {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		MQClient client=new MQClient();
		client.produce("Hello World");
	}
}
