/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class TestHasSelfPrivateNum {
	public static void main(String[] args) {
		HasSelfPrivateNum numRef = new HasSelfPrivateNum();
		ThreadA atThreadA = new ThreadA(numRef);
		atThreadA.start();
		ThreadB aThreadB = new ThreadB(numRef);
		aThreadB.start();
	}
}
