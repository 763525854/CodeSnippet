/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part5;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.ibm.icu.text.SimpleDateFormat;

/**
 * @Author: weiping.gong
 * @Description: 
 * @Date: created in 2018年6月14日
 */
public class Cancel {
	static public class MyTaskA extends TimerTask{
		@Override
		public void run() {
			System.out.println("A运行了！时间为："+new Date());
			this.cancel();
		}
		
	}
	static public class MyTaskB extends TimerTask{

		@Override
		public void run() {
			System.out.println("B运行了！时间为:"+new Date());
		}
		
	}
	
	public static void main(String[] args) {
		try {
			MyTaskA taskA=new MyTaskA();
			MyTaskB taskB=new MyTaskB();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datestring="2014-10-12 09:12:00";
			Timer timer=new Timer();
			Date dateRef=sdf.parse(datestring);
			System.out.println("字符串时间：="+dateRef.toLocaleString()+"当前时间"+new Date().toLocaleString());
			timer.schedule(taskA, dateRef, 4000);
			timer.schedule(taskB, dateRef, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
