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
public class WaitOld {
	private String lock;

	public WaitOld(String lock) {
		super();
		this.lock = lock;
	}

	public void add() {
		synchronized (lock) {
			ValueObject.list.add("anyString");
			lock.notifyAll();
		}
	}

	public static void main(String[] args) {
		String lock = new String("");
		WaitOld add = new WaitOld(lock);
		Subtract subtract = new Subtract(lock);
		ThreadSubtract subtractThread = new ThreadSubtract(subtract);
		subtractThread.setName("subtract111Thread");
		subtractThread.start();
		ThreadSubtract subtract2Thread = new ThreadSubtract(subtract);
		subtract2Thread.setName("subtract2Thread");
		subtract2Thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WaitOldTA addthread = new WaitOldTA(add);
		addthread.setName("addThread");
		addthread.start();
	}
}

class ValueObject {
	public static List list = new ArrayList<>();
}

class Subtract {
	private String lock;

	public Subtract(String lock) {
		super();
		this.lock = lock;
	}

	public void subtract() {
		synchronized (lock) {
			while (ValueObject.list.size() == 0) {
				System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
			}
			ValueObject.list.remove(0);
			System.out.println("list size=" + ValueObject.list.size());
		}
	}
}

class WaitOldTA extends Thread {
	private WaitOld p;

	public WaitOldTA(WaitOld p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		super.run();
		p.add();
	}
}

class ThreadSubtract extends Thread {
	private Subtract r;

	public ThreadSubtract(Subtract r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		super.run();
		r.subtract();
	}
}