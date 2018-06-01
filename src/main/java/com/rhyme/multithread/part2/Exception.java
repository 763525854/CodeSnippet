/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class Exception {
	synchronized public void testMethod() {
		if (Thread.currentThread().getName().equals("a")) {
			System.out.println(
					"ThreadName=" + Thread.currentThread().getName() + " run beginTime=" + System.currentTimeMillis());
			int i = 1;
			while (i == 1) {
				String string="" + Math.random();
				if (string.substring(0, 10).equals("0.62311233")) {
					System.out.println(string);
					System.out.println("ThreadName=" + Thread.currentThread().getName() + " run exceptionTime="
							+ System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		} else {
			System.out.println("Thread B run Time=" + System.currentTimeMillis());
		}
	}
}

class ExceptionThreadA extends Thread {
	private Exception exception;

	public ExceptionThreadA(Exception exception) {
		super();
		this.exception = exception;
	}

	@Override
	public void run() {
		exception.testMethod();
	}
}

class ExceptionThreadB extends Thread {
	private Exception exception;

	public ExceptionThreadB(Exception exception) {
		super();
		this.exception = exception;
	}

	@Override
	public void run() {
		exception.testMethod();
	}
}