/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

import java.util.Random;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class Thread3 extends Thread {
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 50000; i++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("★★★★★ thread 1 use time=" + (endTime - beginTime));
	}
}

class Thread4 extends Thread {
	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 50000; i++) {
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆☆☆☆☆ thread 2 use time=" + (endTime - beginTime));
	}
}
