/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part2;

import lombok.Data;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
@Data
public class RunThread extends Thread {
	private boolean isRunning = true;

	@Override
	public void run() {
		super.run();
		System.out.println("进入run了");
		while (isRunning == true) {

		}
		System.out.println("线程被停止了！");
	}

	public static void main(String[] args) throws InterruptedException {
		RunThread thread = new RunThread();
		thread.start();
		Thread.sleep(1000);
		thread.setRunning(false);
		System.out.println("已经赋值为false");
	}
}
