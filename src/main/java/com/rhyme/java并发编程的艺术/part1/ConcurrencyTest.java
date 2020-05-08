/**
 *  Created by weiping.gong on 2018年6月27日
 */
package com.rhyme.java并发编程的艺术.part1;

/**
 * @Author: weiping.gong
 * @Description:多线程一定更快吗
 * @Date: created in 2018年6月27日
 */
public class ConcurrencyTest {
	private static final long count = 10000000000L;
//	private static final long count = 10000L;

	public static void main(String[] args) throws InterruptedException {
		concuttency();
		serial();
	}

	private static void concuttency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				@SuppressWarnings("unused")
				long a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
				System.out.println("thread inner");
			}
		});
		thread.start();
		long b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		System.out.println("thread out");
		long time = System.currentTimeMillis() - start;
		thread.join();
		long time2 = System.currentTimeMillis() - start;
		System.out.println("concurrency:" + time + "ms,b=" + b);
		System.out.println("concurrency:" + time2 + "ms,b=" + b);
	}

	private static void serial() {
		long start = System.currentTimeMillis();
		long a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}
		long b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
	}
}
