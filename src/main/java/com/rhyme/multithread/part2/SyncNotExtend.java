/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class SyncNotExtend {
	synchronized public void serviceMethod() {
		try {
			System.out.println("int main 下一步 sleep begin threadName=" + Thread.currentThread().getName() + "thime="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main 下一步 sleep end threadName=" + Thread.currentThread().getName() + "thme="
					+ System.currentTimeMillis());
		} catch (java.lang.Exception e) {
		}
	}
}

class SyncNotExtendSub extends SyncNotExtend {
	@Override
	public void serviceMethod() {
		try {
			System.out.println("int sub下一步 sleep begin threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub下一步 sleep begin threadName=" + Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			super.serviceMethod();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class SyncNotExtendThreadA extends Thread {
	private SyncNotExtendSub sub;

	public SyncNotExtendThreadA(SyncNotExtendSub sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}
}

class SyncNotExtendThreadB extends Thread {
	private SyncNotExtendSub sub;

	public SyncNotExtendThreadB(SyncNotExtendSub sub) {
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}
}
