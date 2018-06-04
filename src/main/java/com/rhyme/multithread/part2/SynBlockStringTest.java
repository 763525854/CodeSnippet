/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class SynBlockStringTest {
	public static void main(String[] args) {
		SynBlockString service = new SynBlockString();
		SyncBlockA a = new SyncBlockA(service);
		SyncBlockB b = new SyncBlockB(service);
		a.setName("A");
		a.start();
		b.setName("B");
		b.start();
	}

}
