package com.rhyme.multithread.part4;

import java.util.concurrent.locks.ReentrantLock;

public class IsLocked {
	private ReentrantLock lock;

	public IsLocked(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}

	public void serviceMethod() {
		try {
			System.out.println(lock.isLocked());
			lock.lock();
			System.out.println(lock.isLocked());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final IsLocked service=new IsLocked(true);
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				service.serviceMethod();
			}
		};
		Thread thread=new Thread(runnable);
		thread.start();
	}
}
