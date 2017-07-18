package com.eden.mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class MongoTest {
	public static String mongoDbUserName = "vdcowner";
	public static String mongoDbPwd = "vdcowner";
	public static String mongoDbHost = "hkgcvdv00180";
	public static int mongoDbPort = 27042;
	public static String database = "vdc";
	

	public static void main(String[] args) throws IOException {
		//connect mongo
		MongoCredential credential = MongoCredential.createCredential(mongoDbUserName, database, mongoDbPwd.toCharArray());
		MongoClient mongo = new MongoClient(new ServerAddress(mongoDbHost, mongoDbPort), Arrays.asList(credential));
		MongoDatabase db = mongo.getDatabase(database);
		MongoCollection<Document> collection = db.getCollection("testonly");
		//get json data
		StringBuilder result = new StringBuilder();
		File file = new File("D:\\SourceCode\\grammer-test\\src\\main\\java\\com\\eden\\gson\\data.json");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = null;
		while ((s = br.readLine()) != null) {
			result.append(s);
		}
		br.close();
		//handle data
		collection.deleteMany(new Document());
		
		
		//-------------
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

	    TaskStatusInfo taskStatusInfo = null;
//	    try {
//	      taskStatusInfo = objectMapper.readValue(msgBody, TaskStatusInfo.class);
//	    } catch (IOException e) {
//	      e.printStackTrace();
//	    }

	    Date createdDateTime = new Date();
	    TaskStatus taskStatus = new TaskStatus(UUID.randomUUID().toString(), taskStatusInfo);
	    String tasksStatusString = objectMapper.writeValueAsString(taskStatus);
	    Document newTaskStatus = Document.parse(tasksStatusString);
	    newTaskStatus.append("createdDateTime",createdDateTime);
	    MongoCollection<Document> taskstatusinfosCollection = db.getCollection("taskstatusinfos");

	    taskstatusinfosCollection.insertOne(newTaskStatus);
		//-------------
		String msgBody = result.toString();
		BasicDBList objList = (BasicDBList) JSON.parse(msgBody);
		List<Document> docList = new ArrayList<Document>();
		for (Object obj : objList) {
			Document dbObject = new Document();
			dbObject.append("userStatusInfo", obj);
			dbObject.append("msgId", UUID.randomUUID());
			dbObject.append("createdDateTime", new Date());
			docList.add(dbObject);
		}
		collection.insertMany(docList);
		mongo.close();
		System.out.println("end");
	}
}
