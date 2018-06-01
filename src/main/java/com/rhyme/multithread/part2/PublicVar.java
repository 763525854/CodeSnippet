/**
 *  Created by weiping.gong on 2018年6月1日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月1日
 */
public class PublicVar {
	public String username = "A";
	public String password = "AA";

	synchronized public void setValue(String username, String password) {
		this.username = username;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue method thread name=" + Thread.currentThread().getName() + " username=" + username
				+ " password=" + password);
	}

	synchronized public void getValue() {
		System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " usernam=" + username
				+ " passwor=" + password);
	}
}

class PublicVarThread extends Thread {
	private PublicVar publicVar;

	/**
	 * 
	 */
	public PublicVarThread(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	@Override
	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}
}
