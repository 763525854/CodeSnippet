/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part6;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class MyObject3 {
	private static class MyObjectHandler {
		private static MyObject3 myObject = new MyObject3();
	}

	public MyObject3() {
	}

	public static MyObject3 getInstance() {
		return MyObjectHandler.myObject;
	}
	
	public static void main(String[] args) {
		MyThreadHan t1=new MyThreadHan();
		MyThreadHan t2=new MyThreadHan();
		MyThreadHan t3=new MyThreadHan();
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThreadHan extends Thread{
	@Override
	public void run() {
		super.run();
		System.out.println(MyObject3.getInstance().hashCode());
	}
}
