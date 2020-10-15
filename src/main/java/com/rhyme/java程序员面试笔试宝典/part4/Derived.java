package com.rhyme.java程序员面试笔试宝典.part4;

public class Derived extends Base {
	static {
		System.out.println("derived static block");
	}
	{
		System.out.println("derived block");
	}
	public Derived() {
		System.out.println("derived constructor");
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		new Derived();
	}
}
