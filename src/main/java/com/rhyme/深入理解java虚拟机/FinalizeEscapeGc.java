package com.rhyme.深入理解java虚拟机;

public class FinalizeEscapeGc {
	public static FinalizeEscapeGc SAVEHOOK=null;
	public void isAlive() {
		System.out.println("yes,i am still alive;");
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		FinalizeEscapeGc.SAVEHOOK=this;
	}
	public static void main(String[] args) throws InterruptedException {
		SAVEHOOK=new FinalizeEscapeGc();
		SAVEHOOK=null;
		System.gc();
		Thread.sleep(1000);
		if (SAVEHOOK!=null) {
			SAVEHOOK.isAlive();
		}else {
			System.out.println("no, i am dead");
		}
		SAVEHOOK=null;
		System.gc();
		Thread.sleep(1000);
		if (SAVEHOOK!=null) {
			SAVEHOOK.isAlive();
		}else {
			System.out.println("no, i am dead");
		}
	}
	
}
