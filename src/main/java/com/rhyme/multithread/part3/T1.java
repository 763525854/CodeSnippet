/**
 *  Created by weiping.gong on 2018年6月11日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月11日
 */
public class T1 {
	public static ThreadLocal t1 = new ThreadLocal();

	public static void main(String[] args) {
		if (t1.get()==null) {
			System.out.println("never put value");
			t1.set("my value");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
