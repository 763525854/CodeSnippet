/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

import com.rhyme.multithread.part2.PublicClass.PrivateClass;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
public class PublicClassTest {
	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		publicClass.setUsername("usernameValue");
		publicClass.setPassword("passwordValue");
		System.out.println(publicClass.getUsername() + " " + publicClass.getPassword());
		PrivateClass privateClass = publicClass.new PrivateClass();
		privateClass.setAge("ageValue");
		privateClass.setAddress("addressValue");
		System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
	}
}
