/**
 *  Created by weiping.gong on 2018年5月28日
 */
package com.rhyme.multithread.part1;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年5月28日
 */
public class RunC {
	public static void main(String[] args) {
		CountOperate countOperate=new CountOperate();
		Thread t1=new Thread(countOperate);
		t1.setName("A");
		t1.start();
	}
}
