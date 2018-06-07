/**
 *  Created by weiping.gong on 2018年6月7日
 */
package com.rhyme.multithread.part3;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月7日
 */
public class P {
	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject2.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "__" + System.nanoTime();
				System.out.println("set的值是 " + value);
				ValueObject2.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String lock = new String("");
		P p = new P(lock);
		C r = new C(lock);
		PT1 pt1 = new PT1(p);
		PT2 pt2 = new PT2(r);
		pt1.start();
		pt2.start();
	}
}

class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject2.value.equals("")) {
					lock.wait();
				}
				System.out.println("get 的值是" + ValueObject2.value);
				ValueObject2.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ValueObject2 {
	public static String value = "";
}

class PT1 extends Thread {
	private P p;

	public PT1(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			p.setValue();
		}
	}
}

class PT2 extends Thread {
	private C r;

	public PT2(C r) {
		this.r = r;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			r.getValue();
		}
	}
}