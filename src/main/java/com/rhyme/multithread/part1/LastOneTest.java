/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class LastOneTest {
	public static void main(String[] args) throws InterruptedException {
		LastOne service = new LastOne();
		Userinfo userinfo = new Userinfo();
		LastOneThreada a = new LastOneThreada(service, userinfo);
		LastOneThreadb b = new LastOneThreadb(service, userinfo);
		a.setName("a");
		b.setName("b");
		a.start();
		Thread.sleep(50);
		b.start();
	}
}
