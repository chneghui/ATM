package com.atm.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public class ATMFile {
	public static void write(String str,String filepath) {
		OutputStream in = null;
		try {
			in = new FileOutputStream(filepath ,false);
			in.write(str.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String read(String filepath) {
		BufferedReader f = null;
		try {
			f = new BufferedReader(new FileReader(filepath));
			String str = f.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
