/**
 *  Created by weiping.gong on 2018年5月25日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月25日
 */
public class TestSync {
	public static void main(String[] args) {
		SyncMyThread a=new SyncMyThread("A");
		SyncMyThread b=new SyncMyThread("B");
		SyncMyThread c=new SyncMyThread("C");
		a.start();
		b.start();
		c.start();
	}
}
