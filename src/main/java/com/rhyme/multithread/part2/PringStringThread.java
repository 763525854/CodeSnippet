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
public class PringStringThread implements Runnable {
	private boolean isContinuePrint = true;

	public void printStringMethod() {
		try {
			while (isContinuePrint == true) {
				System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		printStringMethod();
	}

	public static void main(String[] args) {
		PringStringThread pringStringThread = new PringStringThread();
		new Thread(pringStringThread).start();
		System.out.println("我要停止它！stopThread=" + Thread.currentThread().getName());
		pringStringThread.setContinuePrint(false);
	}

}
