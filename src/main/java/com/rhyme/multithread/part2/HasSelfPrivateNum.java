/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class HasSelfPrivateNum {
	private int num = 0;

	synchronized public void addI(String username) {
		try {
			if (username.equals("a")) {
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(username + " num=" + num);
		} catch (java.lang.Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class ThreadA extends Thread {
	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		numRef.addI("a");
	}
}

class ThreadB extends Thread {
	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef) {
		super();
		this.numRef = numRef;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		super.run();
		numRef.addI("b");
	}

}
