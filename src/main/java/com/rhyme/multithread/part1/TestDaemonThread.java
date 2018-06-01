/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class TestDaemonThread {
	public static void main(String[] args) throws InterruptedException {
		DaemonThread daemonThread = new DaemonThread();
		// daemonThread.setDaemon(true);
		daemonThread.start();
		Thread.sleep(5000);
		System.out.println("我离开thread对象也不再打印了，也就是停止了");
	}
}
