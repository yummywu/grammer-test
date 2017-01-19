package com.eden.core;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.eden.dto.Student;

public class StringTest {
	
	public static String str = "C:\\oc4j_10g\\j2ee\\home\\htdocs\\messages\\new\\ZIA7046157_.xml";
	public static String PBL_EDI_TEMP_FILE_PATH = "C:\\oc4j_10g\\j2ee\\home\\htdocs\\messages\\temp\\";
	
	public static void main(String[] args) throws IOException {
//		String fileName = getPblNumByFilePath(str);
//		System.out.println(fileName);
//		Elements newEles = getElementsByNewFilePath(str);
//		String newString = newEles.toString().trim();
//		
//		Elements oldEles = getElementsByOldFilePath(str);
//		String oldsString = oldEles.toString().trim();
//		System.out.println(oldsString);
		Student s1 = new Student("1", 10, "boy");
		Student s2 = new Student("2", 20, "boy");
		Map<String, Student> m1 = new HashMap<String, Student>();
		m1.put("1", s1);
		m1.put("2", s2);
		Collection<Student> c1 = m1.values();
		for (Student s : c1) {
			System.out.println(s.getGender());
		}
		
		System.out.println(new Date().getTime());
	}
	
	public static String getPblNumByFilePath(String filePath) {
		int temp1 = filePath.lastIndexOf("\\");
		int temp2 = filePath.lastIndexOf("_");
		System.out.println(temp1 + ":" + temp2);
		String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1,filePath.lastIndexOf("_"));
		fileName = fileName.toUpperCase();
		return fileName;
	}
	
	public static Elements getElementsByNewFilePath(String newFilePath) throws IOException {
		File newFile = new File(newFilePath);
		String fileContent = FileUtils.readFileToString(newFile, "UTF-8");
		// pre-process file content 
		fileContent = fileContent.replaceAll("obl:", "obl_").replaceAll("xmlns:", "xmlns_").replaceAll("header:", "header_").replaceAll("datatype:", "datatype_");
		
		// extra handle				
		fileContent = fileContent.replaceAll("\\sxmlns_(.*?)=\"([^\"]*?)\"", "").replaceAll("\\<header_RECIPIENT_ID(.*?)header_RECIPIENT_ID\\>", "").replaceAll("\\<header_MSG_CTRL_REF_NUM(.*?)header_MSG_CTRL_REF_NUM\\>", "").replaceAll("\\<header_MSG_CTRL_REF_NUM\\/\\>", "")
				.replaceAll("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}", "").replaceAll("\\d{2}:\\d{2}:\\d{2}", "").replaceAll("ns\\d{2,3}:nil", "xsi:nil").replaceAll("\\<datatype_email(.*?)datatype_email\\>", "");
		
		Document doc = Jsoup.parse(fileContent, "UTF-8");
//		System.out.println("***********************************");
//		System.out.println(doc.html());
//		System.out.println("***********************************");
		Elements newEles = doc.select("body");
		return newEles;
	}
	
	private static Elements getElementsByOldFilePath(String oldFilePath) throws IOException {
		File oldFile = new File(oldFilePath);
		
		String fileContent = FileUtils.readFileToString(oldFile, "UTF-8");
		// pre-process file content 
		fileContent = fileContent.replaceAll("obl:", "obl_").replaceAll("xmlns:", "xmlns_").replaceAll("header:", "header_").replaceAll("datatype:", "datatype_");
		
		// extra handle		
		fileContent = fileContent.replaceAll("\\<header_RECIPIENT_ID(.*?)header_RECIPIENT_ID\\>", "").replaceAll("\\<header_MSG_CTRL_REF_NUM(.*?)header_MSG_CTRL_REF_NUM\\>", "").replaceAll("\\<header_MSG_CTRL_REF_NUM\\/\\>", "")
				.replaceAll("\\d{2}:\\d{2}:\\d{2}\\.\\d{3}", "").replaceAll("\\d{2}:\\d{2}:\\d{2}", "").replaceAll("\\<datatype_email(.*?)datatype_email\\>", "").replaceAll("\\<datatype_area_code\\/\\>", "");
		
		Document doc = Jsoup.parse(fileContent, "UTF-8");
//		System.out.println("***********************************");
//		System.out.println(doc.html());
//		System.out.println("***********************************");
		Elements oldEles = doc.select("obl_obl_msg_root");
		return oldEles;
	}
}
