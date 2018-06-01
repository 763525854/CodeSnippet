/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月1日
 */
public class ServiceTest {
	public static void main(String[] args) {
		ServiceThread thread=new ServiceThread();
		thread.start();
	}
}
