/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月1日
 */
public class TestHasSelfPrivateNum2 {
	public static void main(String[] args) {
		HasSelfPrivateNum numRef1=new HasSelfPrivateNum();
		HasSelfPrivateNum numRef2=new HasSelfPrivateNum();
		ThreadA t1=new ThreadA(numRef1);
		t1.start();
		ThreadB t2=new ThreadB(numRef2);
		t2.start();
	}
}
