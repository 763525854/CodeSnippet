/**
 *  Created by weiping.gong on 2018年5月25日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月25日
 */
public class SyncMyThread extends Thread {

	private int count = 5;

	public SyncMyThread(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println(" 由 " + this.currentThread().getName() + " 计算,count= " + count);
		}
	}

}
