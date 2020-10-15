package com.rhyme.java程序员面试笔试宝典.part4;

public class Base {
	static {
		System.out.println("base static block");
	}
	{
		System.out.println("base block");
	}
	public Base(){
		System.out.println("base constructor");
	}
}
