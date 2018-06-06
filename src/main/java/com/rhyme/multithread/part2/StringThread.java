/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class StringThread {
	private boolean iscontinue = true;

	public void runMethod() {
		while (iscontinue == true) {
			synchronized ("abc") {

			}
		}
		System.out.println("停下来了");
	}

	public void stopMethod() {
		iscontinue = false;
		System.out.println(iscontinue);
	}

	public static void main(String[] args) throws InterruptedException {
		StringThread service = new StringThread();
		ThreadStringA a = new ThreadStringA(service);
		a.start();
		Thread.sleep(1000);
		ThreadStringB b = new ThreadStringB(service);
		b.start();
		System.out.println("已经发送停止命令了。");
	}
}

class ThreadStringA extends Thread {
	private StringThread service;

	public ThreadStringA(StringThread service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.runMethod();
	}
}

class ThreadStringB extends Thread {
	private StringThread service;

	public ThreadStringB(StringThread service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.stopMethod();
	}
}
