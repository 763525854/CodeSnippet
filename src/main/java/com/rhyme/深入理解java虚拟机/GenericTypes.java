package com.rhyme.深入理解java虚拟机;

public class GenericTypes {
	public static void main(String[] args) {
		Integer aInteger=1;
		Integer aInteger2=2;
		Integer aInteger3=3;
		Integer aInteger4=3;
		Integer a=800;
		Integer b=200;
		Integer c=1000;
		Integer e=new Integer(1);
		Integer f=new Integer(1);
		System.out.println(aInteger3==aInteger4);
		System.out.println(aInteger3==(aInteger+aInteger2));
		System.out.println(c==(b+a));
		System.out.println(e==f);
	}

}
