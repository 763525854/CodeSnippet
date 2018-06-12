/**
 *  Created by weiping.gong on 2018年6月12日
 */
package com.rhyme.multithread.part3;

import java.util.Date;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月12日
 */
public class InherThread extends InheritableThreadLocal {
	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
	
	@Override
	protected Object childValue(Object parentValue) {
		return parentValue+"我在子线程加的";
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("在main thread mid get value" + InherTool.t1.get());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ThreadIn aIn = new ThreadIn();
		aIn.start();
		InherTool.t1.set("uu");
		ThreadIn bIn = new ThreadIn();
		bIn.start();
	}
}

class InherTool {
	public static InherThread t1 = new InherThread();
}

class ThreadIn extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("在ThreadA线程中取值=" + InherTool.t1.get());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}