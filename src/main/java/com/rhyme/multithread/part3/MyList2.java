/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月7日
 */
public class MyList2 {
	private static List list = new ArrayList<>();

	public static void add() {
		list.add("anyString");
	}

	public static int size() {
		return list.size();
	}

	public static void main(String[] args) {
		Object lock = new Object();
		Threadc a = new Threadc(lock);
		a.start();
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Threadd b = new Threadd(lock);
		b.start();
	}
}

class Threadc extends Thread {
	private Object lock;

	/**
	 * 
	 */
	public Threadc(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			if (MyList2.size() != 5) {
				System.out.println("wait begin" + System.currentTimeMillis());
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("wait end" + System.currentTimeMillis());
			}
		}
	}
}

class Threadd extends Thread {
	private Object lock;

	public Threadd(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				MyList2.add();
				if (MyList2.size() == 5) {
					lock.notify();
					System.out.println("已发出通知");
				}
				System.out.println("添加了" + (i + 1) + "个元素");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}