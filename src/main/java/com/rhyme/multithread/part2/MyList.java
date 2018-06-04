/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class MyList {
	private List list = new ArrayList<>();

	synchronized public void add(String username) {
		System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了add方法");
		list.add(username);
		System.out.println("ThreadName=" + Thread.currentThread().getName() + "退出了add方法");
	}

	synchronized public int getSize() {
		System.out.println("ThreadName=" + Thread.currentThread().getName() + "执行了getSize方法");
		int sizeValue = list.size();
		System.out.println("ThreadName=" + Thread.currentThread().getName() + "exit getSize方法");
		return sizeValue;
	}
}

class MyListThreada extends Thread {
	private MyList list;

	public MyListThreada(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100000; i++) {
			list.add("threada" + (i + 1));
		}
	}

}

class MyListThreadb extends Thread {
	private MyList list;

	public MyListThreadb(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 100000; i++) {
			list.add("threada" + (i + 1));
		}
	}

}
