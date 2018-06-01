/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class TestStopThread {
	public static void main(String[] args) {
		StopThread thread=new StopThread();
		thread.start();
		try {
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		
	}
}
