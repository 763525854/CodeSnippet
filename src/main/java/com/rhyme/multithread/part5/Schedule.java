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
public class Schedule {
	static public class MyTask extends TimerTask {

		@Override
		public void run() {
			System.out.println("运行了！时间为" + new Date());
		}

	}

	public static void main(String[] args) {
		try {
			MyTask task = new MyTask();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = "2015-10-12 10:12:00";
			Timer timer = new Timer();
			Date date = sdf.parse(dateString);
			System.out.println("字符串时间:" + date.toLocaleString() + "当前时间：" + new Date().toLocaleString());
			timer.schedule(task, date, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
