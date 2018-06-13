/**
 *  Created by weiping.gong on 2018年6月12日
 */
package com.rhyme.multithread.part4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月12日
 */
public class HoldCount {
	
	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethod1() {
		try {
			lock.lock();
			System.out.println("servicemethod1 getHoldCount=" + lock.getHoldCount());
			serviceMethod2();
		} finally {
			System.out.println("haha");
			lock.unlock();
		}

	}

	public void serviceMethod2() {
		try {
			lock.lock();
			System.out.println("servicemethod2 getHoldCount=" + lock.getHoldCount());
		} finally {
			System.out.println("bbb");
			lock.unlock();
		}

	}
	
	public static void main(String[] args) {
		HoldCount service=new HoldCount();
		service.serviceMethod1();
	}
}
