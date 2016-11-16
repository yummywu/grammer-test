package com.eden.core.io;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter writer;
		BufferedInputStream bis;
		try {
			writer = new FileWriter("d:\\a.txt");
			for (int c=0; c<5000; c++) {
				writer.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
