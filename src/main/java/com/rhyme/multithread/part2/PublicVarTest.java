/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class PublicVarTest {
	public static void main(String[] args) throws InterruptedException {
		PublicVar publicVar = new PublicVar();
		PublicVarThread thread = new PublicVarThread(publicVar);
		thread.start();
		Thread.sleep(200);
		publicVar.getValue();
	}
}
