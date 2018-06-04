/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class SyncString {
	public void pring(String stringParam) {
		synchronized (stringParam) {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class SyncThreadA extends Thread {
	private SyncString service;

	public SyncThreadA(SyncString service) {
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.pring("AA");
	}
}

class SyncThreadB extends Thread {
	private SyncString service;

	public SyncThreadB(SyncString service) {
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.pring("BB");
	}
}
