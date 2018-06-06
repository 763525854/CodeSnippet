/**
 *  Created by weiping.gong on 2018年6月6日
 */
package com.rhyme.multithread.part1;

import lombok.Data;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月6日
 */
public class LastOne {
	public void serviceMethodA(Userinfo userinfo) {
		synchronized (userinfo) {
			try {
				System.out.println(Thread.currentThread().getName());
				userinfo.setUsername("abcabcabc");
				Thread.sleep(3000);
				System.out.println("end! time=" + System.currentTimeMillis());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

@Data
class Userinfo {
	private String username;
}

class LastOneThreada extends Thread {
	private LastOne service;
	private Userinfo userinfo;

	public LastOneThreada(LastOne service, Userinfo userinfo) {
		super();
		this.service = service;
		this.userinfo = userinfo;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethodA(userinfo);
	}
}

class LastOneThreadb extends Thread {
	private LastOne service;
	private Userinfo userinfo;

	public LastOneThreadb(LastOne service, Userinfo userinfo) {
		super();
		this.service = service;
		this.userinfo = userinfo;
	}

	@Override
	public void run() {
		super.run();
		service.serviceMethodA(userinfo);
	}
}