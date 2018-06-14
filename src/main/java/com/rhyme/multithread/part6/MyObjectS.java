/**
 *  Created by weiping.gong on 2018年6月14日
 */
package com.rhyme.multithread.part6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月14日
 */
public class MyObjectS implements Serializable {

	private static final long serialVersionUID = 9168218393838590072L;

	private static class MyObjectSHandler {
		private static final MyObjectS object = new MyObjectS();
	}

	public MyObjectS() {
	}

	public static MyObjectS getInstance() {
		return MyObjectSHandler.object;
	}

	protected Object readResolve() throws ObjectStreamException {
		System.out.println("调用了readResolve方法");
		return MyObjectSHandler.object;
	}

	public static void main(String[] args) {
		try {
			MyObjectS myObject = MyObjectS.getInstance();
			FileOutputStream fosRef = new FileOutputStream(new File("my.txt"));
			ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
			oosRef.writeObject(myObject);
			oosRef.close();
			fosRef.close();
			System.out.println(myObject.hashCode());
		} catch (Exception e) {
		}
		try {
			FileInputStream fisRef = new FileInputStream(new File("my.txt"));
			ObjectInputStream iosRef = new ObjectInputStream(fisRef);
			MyObjectS myobject = (MyObjectS) iosRef.readObject();
			iosRef.close();
			fisRef.close();
			System.out.println(myobject.hashCode());
		} catch (Exception e) {
		}
	}
}
