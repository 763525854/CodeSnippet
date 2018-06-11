/**
 *  Created by weiping.gong on 2018年6月11日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月11日
 */
public class MyThread extends Thread{
	@Override
	public void run() {
		super.run();
		int secondValue=(int) (Math.random()*10000);
		System.out.println(secondValue);
		try {
			Thread.sleep(secondValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyThread threadTest=new MyThread();
		threadTest.start();
		try {
			threadTest.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我想当threadTest对象执行完毕后我再执行");
		System.out.println("但上面代码中的sleep()中的值应该写多少呢？");
		System.out.println("答案是:根据不能确定");
	}
}
