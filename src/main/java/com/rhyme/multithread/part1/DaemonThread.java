/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class DaemonThread extends Thread {
	private int i = 0;

	@Override
	public void run() {
		while (true) {
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i=" + (i));
		}
	}
}
