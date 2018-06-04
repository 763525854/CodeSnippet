/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class ObjectService {
	public void serviceMethod() {
		synchronized (this) {
			System.out.println("begin time=" + System.currentTimeMillis());
			try {
				Thread.sleep(2000);
				System.out.println("end time=" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ObjectServiceThreadA extends Thread {
	private ObjectService objectService;

	public ObjectServiceThreadA(ObjectService objectService) {
		super();
		this.objectService = objectService;
	}

	@Override
	public void run() {
		super.run();
		objectService.serviceMethod();
	}
}

class ObjectServiceThreadB extends Thread {
	private ObjectService objectService;

	public ObjectServiceThreadB(ObjectService objectService) {
		super();
		this.objectService = objectService;
	}

	@Override
	public void run() {
		super.run();
		objectService.serviceMethod();
	}
}
