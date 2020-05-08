package com.rhyme.java并发编程的艺术.part1;

public class JoinDemo extends Thread{
	int i;
	Thread previousThread;
	public JoinDemo(Thread previousThread,int i) {
		this.previousThread=previousThread;
		this.i=i;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			System.out.println("   ");
			previousThread.join();
			//第一次是main.join
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("num:"+i);
	}
	
	public static void main(String[] args) throws Exception {
		Thread previousThread=Thread.currentThread();
		System.out.println("haha1");
		previousThread.join();
		System.out.println("haha");
//		for (int i = 0; i < 2; i++) {
//			System.out.println(previousThread.getName());
//			JoinDemo joinDemo=new JoinDemo(previousThread, i);
//			joinDemo.start();
//			System.out.println("before"+i);
//			previousThread=joinDemo;
//			System.out.println("after"+i);
//		}
	}
}
