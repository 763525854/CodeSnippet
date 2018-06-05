/**
 *  Created by weiping.gong on 2018年6月5日
 */
package com.rhyme.multithread.part2;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月5日
 */
public class OutClass1 {
	static class InnerClass1 {
		public void method1(InnerClass2 class2) throws InterruptedException {
			String threadName = Thread.currentThread().getName();
			synchronized (class2) {
				System.out.println(threadName + "进入InnerClass1类中的method1方法");
				for (int i = 0; i < 10; i++) {
					System.out.println("i=" + i);
					Thread.sleep(100);
				}
				System.out.println(threadName + "离开InnerClass1类中的method2方法");
			}
		}

		public synchronized void method2() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "进入InnerClass类中的method2方法");
			for (int j = 0; j < 10; j++) {
				System.out.println("j="+j);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			System.out.println(threadName + "离开InnerClass1类中的method2方法");
		}
	}

	static class InnerClass2 {
		public synchronized void method1() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "进入innerclass2类中的method1方法");
			for (int k = 0; k < 10; k++) {
				System.out.println("k=" + k);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(threadName + "离开innerclass2类中的method1方法");
		}
	}
}
