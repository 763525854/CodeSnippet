/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
public class TestThread3 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread3 t3=new Thread3();
			t3.setPriority(1);
			t3.start();
			Thread4 t4=new Thread4();
			t4.setPriority(10);
			t4.start();
		}
	}
}
