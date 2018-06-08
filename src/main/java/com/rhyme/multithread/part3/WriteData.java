/**
 *  Created by weiping.gong on 2018年6月8日
 */
package com.rhyme.multithread.part3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author: weiping.gong
 * @Description:
 * @Date: created in 2018年6月8日
 */
public class WriteData {
	public void writeMethod(PipedOutputStream out) {
		System.out.println("write : ");
		for (int i = 0; i < 300; i++) {
			String outData = "" + (i + 1);
			try {
				out.write(outData.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(outData);
		}
		System.out.println();
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ReadData {
	public void readMethod(PipedInputStream input) {
		try {
			System.out.println("read: ");
			byte[] byteArray = new byte[20];
			int leadLength;
			leadLength = input.read(byteArray);
			while (leadLength != -1) {
				String newData = new String(byteArray, 0, leadLength);
				System.out.println(newData);
				leadLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}