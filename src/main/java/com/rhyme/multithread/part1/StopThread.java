/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class StopThread extends Thread{
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			System.out.println("i="+(i+1));
		}
	}
}
