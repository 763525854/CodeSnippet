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
public class SynBlockString {
	private String usernameParam;
	private String passwordParam;

	public void setUsernamePassword(String username, String password) {
		try {
			String anyString = new String();
			synchronized (anyString) {
				System.out.println(
						"线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
				usernameParam = username;
				Thread.sleep(3000);
				passwordParam = password;
				System.out.println(
						"线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SyncBlockA extends Thread {
	private SynBlockString service;

	public SyncBlockA(SynBlockString service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.setUsernamePassword("a", "aa");
	}
}

class SyncBlockB extends Thread {
	private SynBlockString service;

	public SyncBlockB(SynBlockString service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		super.run();
		service.setUsernamePassword("b", "bb");
	}
}
