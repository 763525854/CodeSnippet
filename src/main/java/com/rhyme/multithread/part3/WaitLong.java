/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月7日
 */
public class WaitLong {
	static private Object lock = new Object();
	static private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("wait begin timer=" + System.currentTimeMillis());
				try {
					lock.wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("wait end time=" + System.currentTimeMillis());
			}
		}
	};

	public static void main(String[] args) {
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
