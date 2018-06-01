/**
 *  Created by weiping.gong on 2018年5月31日
 */
package com.rhyme.multithread.part1;

import lombok.Data;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年5月31日
 */
@Data
public class FastThread extends Thread {
	private long count = 0;

	@Override
	public void run() {
		while (true) {
			count++;
		}
	}
}

@Data
class ThreadB extends Thread {
	private long count = 0;

	@Override
	public void run() {
		while (true) {
			count++;
		}
	}
}