package com.rhyme.multithread.part4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {
	public ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	public void waitMethod() {
		try {
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("lock begin "+Thread.currentThread().getName());
			for (int i = 0; i < Integer.MAX_VALUE/10; i++) {
				String newString=new String();
				Math.random();
			}
			System.out.println("lock end"+Thread.currentThread().getName());
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final LockInterruptibly service=new LockInterruptibly();
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				service.waitMethod();
			}
		};
		Thread threadA=new Thread(runnable);
		threadA.setName("A");
		threadA.start();
		Thread.sleep(500);
		Thread threadB=new Thread(runnable);
		threadB.setName("B");
		threadB.start();
		System.out.println("中断");
		threadB.interrupt();
		System.out.println("main end");
	}
}
