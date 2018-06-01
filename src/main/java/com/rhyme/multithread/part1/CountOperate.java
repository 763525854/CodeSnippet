/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class CountOperate extends Thread{
	/**
	 * 
	 */
	public CountOperate() {
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("CountOperate---end");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("run---end");
	}

}
