/**
 *  Created by weiping.gong on 2018年5月25日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月25日
 */
public class MyRunnable implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("运行中！");
	}

}
