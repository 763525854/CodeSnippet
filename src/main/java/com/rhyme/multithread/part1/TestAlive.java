/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class TestAlive {
	public static void main(String[] args) {
		AThread aThread=new AThread();
		System.out.println(aThread.isAlive());
		aThread.run();
			System.out.println(aThread.isAlive());
	}
}

class AThread extends Thread{
	@Override
	public void run() {
		System.out.println("run="+this.isAlive());
	}
}