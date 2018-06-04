/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月4日
 */
public class SyncStringTest {
	public static void main(String[] args) {
		SyncString service=new SyncString();
		SyncThreadA a=new SyncThreadA(service);
		SyncThreadB b=new SyncThreadB(service);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}
}
