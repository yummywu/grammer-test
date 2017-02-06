package com.eden.gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.eden.gson.model.TeamActivity;
import com.google.gson.Gson;

public class String2Json {

	public static void main(String[] args) throws IOException {

		StringBuilder result = new StringBuilder();

		File file = new File("D:\\SourceCode\\grammer-test\\src\\main\\java\\com\\eden\\gson\\data.json");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = null;
		while ((s = br.readLine()) != null) {
			result.append(System.lineSeparator() + s);
		}
		br.close();

		System.out.println(result.indexOf(":"));
		System.out.println(result.lastIndexOf("}"));
		
		String jsonStr = result.substring(result.indexOf(":")+1, result.lastIndexOf("}"));
		TeamActivity activity = fromJson(jsonStr, TeamActivity.class);

		System.out.println(fromJson(jsonStr, TeamActivity.class));

		// System.out.println(result);

//		String jsonStr = prepareData();
		
		 Gson gson = new Gson();
//		 TeamActivity obj = gson.fromJson(jsonStr, TeamActivity.class);
		TeamActivity obj1 = fromJson(jsonStr, TeamActivity.class);
//		List<String> c = obj.getCollects();
//		List<Comment> comments = obj.getComments();
//		for (Comment s : comments) {
//			System.out.println(s.getContent());
//		}
		System.out.println(obj1.getTitle());

	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		try {
			Gson gson = new Gson();
			return gson.fromJson(json, classOfT);
		} catch (Throwable t) {

		}
		return null;
	}

	static String prepareData() throws IOException {
		String pathName = "D:\\SourceCode\\grammer-test\\src\\main\\java\\com\\eden\\gson\\data.json";
		BufferedReader br = new BufferedReader(new FileReader(pathName));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		System.out.println(sb.toString());
		return sb.toString();
	}

}
