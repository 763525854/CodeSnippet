/**
 *  Created by weiping.gong on 2018年6月11日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月11日
 */
public class JoinA extends Thread {
	private JoinB b;

	public JoinA(JoinB b) {
		this.b = b;
	}

	@Override
	public void run() {
		super.run();
		synchronized (b) {
			System.out.println("AAAA start" + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("AAAA end" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		JoinB b = new JoinB();
		JoinA a = new JoinA(b);
		a.start();
		b.start();
		try {
			b.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main mian main");
	}
}

class JoinB extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("BBB start" + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("BBB end" + Thread.currentThread().getName());
	}
}
