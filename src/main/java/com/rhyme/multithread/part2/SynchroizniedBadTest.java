/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class SynchroizniedBadTest {
	public static void main(String[] args) {
		SynchroizniedBad task = new SynchroizniedBad();
		ThreadBadA thread1 = new ThreadBadA(task);
		thread1.start();
		ThreadBadB thread2 = new ThreadBadB(task);
		thread2.start();
		try {
			Thread.sleep(10000);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		long beginTime = CommonUtils.beginTime1;
		if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
			beginTime = CommonUtils.beginTime2;
		}
		long endTime = CommonUtils.endTime1;
		if (CommonUtils.endTime2 > CommonUtils.endTime1) {
			endTime = CommonUtils.endTime2;
		}
		System.out.println("耗时:" + (endTime - beginTime) / 1000);
	}
}
