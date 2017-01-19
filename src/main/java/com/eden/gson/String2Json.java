package com.eden.gson;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

=======
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.eden.gson.model.Comment;
>>>>>>> 6e12b0fc072f3f7bed6ae74ae5e8ede837521aa2
import com.eden.gson.model.TeamActivity;
import com.google.gson.Gson;

public class String2Json {

	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
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
=======
		String jsonStr = prepareData();
		
		 Gson gson = new Gson();
//		 TeamActivity obj = gson.fromJson(jsonStr, TeamActivity.class);
		TeamActivity obj1 = fromJson(jsonStr, TeamActivity.class);
//		List<String> c = obj.getCollects();
//		List<Comment> comments = obj.getComments();
//		for (Comment s : comments) {
//			System.out.println(s.getContent());
//		}
		System.out.println(obj1.getTitle());
>>>>>>> 6e12b0fc072f3f7bed6ae74ae5e8ede837521aa2
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		try {
			Gson gson = new Gson();
			return gson.fromJson(json, classOfT);
		} catch (Throwable t) {

		}
		return null;
	}
<<<<<<< HEAD
=======
	
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
>>>>>>> 6e12b0fc072f3f7bed6ae74ae5e8ede837521aa2

}
