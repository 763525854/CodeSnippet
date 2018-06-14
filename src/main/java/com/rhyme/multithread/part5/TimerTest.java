/**
 *  Created by weiping.gong on 2018年6月13日
 */
package com.rhyme.multithread.part5;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.ibm.icu.text.SimpleDateFormat;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月13日
 */
public class TimerTest {
	private static Timer timer = new Timer();

	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			System.out.println("running! time is" + new Date());
		}

	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2018-06-14 10:56:00";
			Date dateRef = sdFormat.parse(dateString);
			System.out.println("string time :" + dateRef.toLocaleString() + "now time:" + new Date().toString());
			timer.schedule(task, dateRef);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
