/**
 *  Created by weiping.gong on 2018年5月22日
 */
package com.rhyme.headfirst.part4;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月22日
 */
public class TestTimpe {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			String string = new String(Long.toString(System.currentTimeMillis()));
			strings.add(string);
		}
		for (String string : strings) {
			System.out.println(string);
		}
	}
}
