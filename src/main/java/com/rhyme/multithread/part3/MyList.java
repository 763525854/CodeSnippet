/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class MyList {
	private List list = new ArrayList<>();

	public void add() {
		list.add("gaohongyan");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		MyList service = new MyList();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
	}
}

class ThreadA extends Thread {
	private MyList list;

	public ThreadA(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			list.add();
			System.out.println("have add " + (i + 1) + " element");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadB extends Thread {
	private MyList list;

	public ThreadB(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				if (list.size() == 5) {
					System.out.println("==5了，线程b要退出了！");
					throw new InterruptedException();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}