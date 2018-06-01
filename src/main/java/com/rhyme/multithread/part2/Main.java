/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class Main {
	public int i = 10;

	synchronized public void operateIMainMethod() {
		try {
			i--;
			System.out.println("main print i=" + i);
			Thread.sleep(100);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class Sub extends Main {
	synchronized public void operateISubMethod() {
		try {
			while (i > 0) {
				i--;
				System.out.println("sub print i=" + i);
				Thread.sleep(100);
				this.operateIMainMethod();
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}

class MianThread extends Thread{
	@Override
	public void run() {
		Sub sub=new Sub();
		sub.operateISubMethod();
	}
}
