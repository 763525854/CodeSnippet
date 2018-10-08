package com.rhyme.分布式消息中间件实践;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
	// 队列存储消息的最大数量
	private final static int MAX_SIZE = 3;
	// 保存消息数据的容器
	private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

	// 生产消息
	public static void produce(String msg) {
		if (messageQueue.offer(msg)) {
			System.out.println("成功向消息处理中心投递消息:" + msg + ",当前暂存的消息数量是" + messageQueue.size());
		} else {
			System.out.println("消息处理中心暂存的消息达到最大负荷,不能继续放入消息");
		}
		System.out.println("==============================");
	}

	// 消费消息
	public static String consume() {
		String msg = messageQueue.poll();
		if (msg != null) {
			// 消费满足条件，从消息容器中取出一条消息
			System.out.println("已经消费信息:" + msg + "当前暂存的消息数量是" + messageQueue.size());
		} else {
			System.out.println("消息处理中心内没有消息可供消费");
		}
		System.out.println("=============");
		return msg;
	}
}
