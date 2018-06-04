/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class SynMyObjectTest {
	public static void main(String[] args) {
		SynService service = new SynService();
		SynMyObject object1 = new SynMyObject();
		SynMyObject object2 = new SynMyObject();
		
		SynThread1 a = new SynThread1(object1, service);
		SynThread2 b = new SynThread2(object2, service);
		a.setName("a");
		b.setName("b");
		a.start();
		b.start();
	}
}
