/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class ExceptionTest {
	public static void main(String[] args) throws InterruptedException {
		Exception exception = new Exception();
		ExceptionThreadA a = new ExceptionThreadA(exception);
		a.setName("a");
		a.start();
		Thread.sleep(500);
		ExceptionThreadB b = new ExceptionThreadB(exception);
		b.setName("b");
		b.start();
	}

}
