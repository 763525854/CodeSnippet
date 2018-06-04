/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class ObjectServiceTest {
	public static void main(String[] args) {
		ObjectService service = new ObjectService();
		ObjectServiceThreadA a = new ObjectServiceThreadA(service);
		ObjectServiceThreadB b = new ObjectServiceThreadB(service);
		a.setName("a");
		a.start();
		b.setName("b");
		b.start();
	}
}
