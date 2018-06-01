/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
//		MyThread thread=new MyThread();
//		thread.start();
//		Thread.sleep(1000);
//		thread.interrupt();
//		System.out.println("是否停止1?="+thread.interrupted());
//		System.out.println("是否停止2?="+thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("是否停止1？"+Thread.interrupted());
		System.out.println("是否停止2？"+Thread.interrupted());
		System.out.println("end!");
	}
}
