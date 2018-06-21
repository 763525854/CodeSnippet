/**
 *  Created by weiping.gong on 2018年6月21日
 */
package com.rhyme.Java并发编程实战.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月21日
 */
public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReadThread extends Thread {
		@Override
		public void run() {
			super.run();
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new ReadThread().start();
		number = 42;
		ready = true;
	}
}
