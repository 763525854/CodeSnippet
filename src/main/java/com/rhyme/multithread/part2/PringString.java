/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part2;

import lombok.Data;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
@Data
public class PringString {
	private boolean isContinuePrint = true;

	public void printStringMethod() throws InterruptedException {
		while (isContinuePrint == true) {
			System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PringString pringString = new PringString();
		pringString.printStringMethod();
		System.out.println("我要停止它!stopThread=" + Thread.currentThread().getName());
		pringString.setContinuePrint(false);
	}
}
