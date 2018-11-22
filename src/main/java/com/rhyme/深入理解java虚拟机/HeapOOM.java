package com.rhyme.深入理解java虚拟机;

import java.util.ArrayList;
import java.util.List;
//Vm arguments参数        -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\job -XX:SurvivorRatio=8
public class HeapOOM {
	static class OOMObject{}
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
