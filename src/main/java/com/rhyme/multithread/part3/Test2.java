/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月7日
 */
public class Test2 {
	public static void main(String[] args) {
		String lock=new String();
		System.out.println("syn上面");
		synchronized (lock) {
			System.out.println("sync第一行");
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wait下的代码");
		}
		System.out.println("sync下的代码啊");
	}
}
