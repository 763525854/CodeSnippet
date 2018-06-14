/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part6;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class StaticSingle {
	private static StaticSingle instance = null;

	private StaticSingle() {
	}

	static {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		instance = new StaticSingle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static StaticSingle getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		ThreadSs t1 = new ThreadSs();
		ThreadSs t2 = new ThreadSs();
		ThreadSs t3 = new ThreadSs();
		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadSs extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 5; i++) {
			System.out.println(StaticSingle.getInstance().hashCode());
		}
	}
}
