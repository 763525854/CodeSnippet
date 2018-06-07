/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月7日
 */
public class Test1 {
	public static void main(String[] args) {
		String newString=new String("");
		try {
			newString.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
