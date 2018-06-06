/**
 *  Created by weiping.gong on 2018年6月5日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月5日
 */
public class SynMyServiceTest {
	public static void main(String[] args) throws InterruptedException {
		SynMyService service = new SynMyService();
		SynMyServiceThreada a = new SynMyServiceThreada(service);
		SynMyServiceThreadb b = new SynMyServiceThreadb(service);
		a.setName("A");
		b.setName("B");
		a.start();
		Thread.sleep(50);
		b.start();
	}
}
