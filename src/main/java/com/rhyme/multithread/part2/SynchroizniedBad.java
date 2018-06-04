/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class SynchroizniedBad {
	private String getData1;
	private String getData2;

	public void doLongTimeTask() {
		try {
			System.out.println("begin task");
			Thread.sleep(3000);
			String privagegetData1 = "长时间处理任务后从远程返回的值1 threadName=" + Thread.currentThread().getName();
			String privagegetData2 = "长时间处理任务后从远程返回的值2 threadName=" + Thread.currentThread().getName();
			synchronized (this) {
				getData1 = privagegetData1;
				getData2 = privagegetData2;
			}
			System.out.println(getData1);
			System.out.println(getData2);
			System.out.println("end task");
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class CommonUtils {
	public static long beginTime1;
	public static long endTime1;
	public static long beginTime2;
	public static long endTime2;
}

class ThreadBadA extends Thread {
	private SynchroizniedBad task;

	public ThreadBadA(SynchroizniedBad task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime1 = System.currentTimeMillis();
	}
}

class ThreadBadB extends Thread {
	private SynchroizniedBad task;

	public ThreadBadB(SynchroizniedBad task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime2 = System.currentTimeMillis();
	}
}
