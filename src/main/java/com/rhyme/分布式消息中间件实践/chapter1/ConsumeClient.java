package com.rhyme.分布式消息中间件实践.chapter1;
//消费消息
public class ConsumeClient {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		MQClient client=new MQClient();
		String message=client.consume();
		System.out.println("获取的消息为:"+message);
	}
}
