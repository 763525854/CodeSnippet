/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class MyListTest {
	public static void main(String[] args) {
		MyList myList = new MyList();
		MyListThreada a = new MyListThreada(myList);
		MyListThreadb b = new MyListThreadb(myList);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}
}
