/**
 *  Created by weiping.gong on 2018年6月4日
 */
package com.rhyme.multithread.part2;

import lombok.Data;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月4日
 */
@Data
public class PublicClass {
	private String username;
	private String password;

	@Data
	public class PrivateClass {
		private String age;
		private String address;

		public void pringPublicProperty() {
			System.out.println(username + " " + password);
		}
	}
}
