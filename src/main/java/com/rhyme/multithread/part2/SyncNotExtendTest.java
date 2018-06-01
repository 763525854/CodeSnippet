/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class SyncNotExtendTest {
	public static void main(String[] args) {
		SyncNotExtendSub sub = new SyncNotExtendSub();
		SyncNotExtendThreadA a = new SyncNotExtendThreadA(sub);
		a.setName("A");
		a.start();
		SyncNotExtendThreadB b = new SyncNotExtendThreadB(sub);
		b.setName("B");
		b.start();
	}
}
