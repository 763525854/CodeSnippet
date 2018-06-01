/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class RunMyObject {
	public static void main(String[] args) throws InterruptedException {
		final MyObject myObject = new MyObject();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				myObject.setValue("a", "aa");
			}
		};
		thread1.setName("a");
		thread1.start();
		Thread.sleep(500);
		Thread thread2 = new Thread() {
			public void run() {
				myObject.printUsernamePassword();
			};
		};
		thread2.start();
	}
}
