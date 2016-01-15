package com.eden.core;
import java.io.File;
import java.io.IOException;


public class FileSytemTest {
	int a = 88;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String path = "D:\\world\\ok\\what\\why\\.classpath";
//		File fileA = new File(path);
//		fileA.listFiles();
//		String pathb = "D:\\world\\ok\\b.txt";
//		File fileB = new File(pathb);
//		File whatPath = new File("D:\\FGP\\ISDC-ZHA FGP_Evaluation Form - Edeb Wu - 201403.doc");
//		System.out.println(whatPath.lastModified());
//		System.out.println(fileB.length());
//		
//		File[] files = whatPath.listFiles();
//		File[] fileRoots = whatPath.listRoots();
//		whatPath.getName();
//		whatPath.getTotalSpace();
//		whatPath.getAbsoluteFile();
//		whatPath.getFreeSpace();
//		whatPath.getParent();
//		whatPath.getParentFile();
//		System.out.println(fileB);
//		System.out.println(fileB.createNewFile());
//		System.out.println(fileB.isAbsolute());
//		System.out.println(fileB.isDirectory());
//		System.out.println(fileB.isFile());
//		System.out.println(fileB.createNewFile());
		
		String path = "D:\\world\\a.ppt";
		String destPath = "D:\\a.txt";
		
		File fileA = new File(path);
		File fileB = new File(destPath);
		System.out.println(fileA.renameTo(fileB));
		
	}

}
