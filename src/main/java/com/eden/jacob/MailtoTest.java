package com.eden.jacob;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Arrays;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class MailtoTest {
	
	 private static String uriStr = String.format("mailto:%s?subject=%s&body=%s",
	            join(",", Arrays.asList("john@example.com", "jane@example.com")), // use semicolon ";" for Outlook!
	            urlEncode("Hello!"),
	            urlEncode("This is\nan automatically sent email!\n "
	            		+ "Meteorologists generally define four seasons in many climatic areas: spring, summer, autumn (fall) and winter. These are demarcated by the values of their average temperatures on a monthly basis, with each season lasting three months. The three warmest months are by definition summer, the three coldest months are winter and the intervening gaps are spring and autumn. Spring, when defined in this manner, can start on different dates in different regions In some cultures in the Northern Hemisphere (e.g. Germany), the astronomical Vernal "
	            		+ "equinox (varying between 19 and 21 March) is taken to mark the first day of spring, and the Summer solstice (around 21 June) is taken as the first day of summer. In Persian culture the first day of spring is the first day of the first month (called Farvardin) "
	            		+ "which begins on 20 or 21 March. In other traditions, the equinox is taken as mid-spring The beginning of spring is not always determined by fixed calendar dates."
	            		+ " The phenological or ecological definition of spring relates to biological indicators, such as the blossoming of a range of plant species, the activities of animals, and the special smell of soil that has reached the temperature for micro flora to"
	            		+ " flourish. These indicators, along with the beginning of spring, vary according to the local climate and according to "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "the specific weather of a particular year. Most ecologists divide the year into six seasons that have no fixed dates. In addition "
	            		+ "to spring, ecological reckoningss"));

	public static void main(String[] args) throws IOException, URISyntaxException {
		
//		ActiveXComponent oOutlook =   ActiveXComponentHelper.newActiveXComp("Outlook.Application");
//		ActiveXComponent oOutlook = new ActiveXComponent("Outlook.Application");
//        Dispatch mail = Dispatch.invoke(oOutlook.getObject(), "CreateItem", Dispatch.Get, new Object[] { "0" }, new int[0])
//                        .toDispatch();
//        Dispatch.put(mail, "HTMLBody", htmlText);
//        Dispatch attachmentsObj = Dispatch.get(mail, "Attachments").toDispatch();
		
		 ActiveXComponent axOutlook = new ActiveXComponent("Outlook.Application");    
         //Dispatch ds = axOutlook.getObject();  
        /* Dispatch namespace = Dispatch.call(axOutlook, "GetNamespace", "MAPI").toDispatch() ; 
         String path = new File("F:/test.htm").getAbsolutePath();  
         Dispatch mailItem = Dispatch.call(namespace, "OpenSharedItem", path).toDispatch(); */  
           
           
         Dispatch mailItem = Dispatch.call(axOutlook, "CreateItem", 0).getDispatch();    
           
         //Dispatch mailItem = Dispatch.call(axOutlook, "Open", "F:/test.htm").toDispatch();  
        // Dispatch body = Dispatch.call(mailItem, "Body").getDispatch();;    
        // Dispatch.call(body, "Copy");  
           
         Dispatch inspector = Dispatch.get(mailItem, "GetInspector").getDispatch();  

         //收件人    
         Dispatch recipients = Dispatch.call(mailItem, "Recipients").getDispatch();    
         Dispatch.call(recipients, "Add" , "crycbj@163.com");    
         //邮件主题    
         Dispatch.put(mailItem, "Subject", "Test5!");    
         Dispatch.put(mailItem, "CC", "1@qq.com");    
         //Dispatch.put(mailItem, "CC", "cry@163.com");    
         //Dispatch.put(mailItem, "ReadReceiptRequested", "false");   
           
         String body = "<html><body><div style='color:red;'>This is a Test !</div></body></html>";  
         //Dispatch.put(mailItem, "HTMLBody", body);   
           
        // File file = new File("C:/test.htm");  
//       FileOutputStream f = new FileOutputStream("F:/test.htm");  
//       f.write(body.getBytes());  
//       f.close();  
           
         BufferedReader bf = new BufferedReader(new FileReader(new File("D:/mailto_test.html")));  
         String html = "";  
         String str = "";  
         while( (str=bf.readLine()) != null){  
             html += str;  
         }  
         Dispatch.put(mailItem, "HTMLBody", html);   
           
         //Dispatch bodyDis = Dispatch.get(mailItem, "Body").toDispatch();    
         //Dispatch.call(bodyDis, "Add" , "F:/test.htm");    
         //Dispatch.put(mailItem, "Body", new Variant("F:/test.htm"));    
           
         //Dispatch.put(mailItem, "Body", body);    
         //Dispatch.call(mailItem, "InsertAfter",body );//插入一个段落  
           
         //Dispatch selection = Dispatch.get(axOutlook, "Selection").toDispatch();  
           
         //Dispatch inHtmleditor = Dispatch.call(inspector, "HTMLEditor").getDispatch();  
        // Dispatch.call(inHtmleditor, "Paste").getDispatch();    
         //Dispatch.invoke(inHtmleditor, "Paste", Dispatch.Method, new Object[]{false}, new Variant(false));  
           
         //附件    
//           Dispatch attachments = Dispatch.call(mailItem, "Attachments").getDispatch();    
//           Dispatch.call(attachments, "Add" , "D:\\20110127.txt");    
//           Dispatch.call(attachments, "Add" , "D:\\20110128.txt");    
         //显示新邮件窗口    
           
         Dispatch.call(mailItem, "Display");    
//         Dispatch.call(mailItem, "Send");   
        
        
        
        
		 
//		    Desktop.getDesktop().browse(new URI(uriStr));

	}

	public static final String join(String sep, Iterable<?> objs) {
	    StringBuilder sb = new StringBuilder();
	    for(Object obj : objs) {
	        if (sb.length() > 0) sb.append(sep);
	        sb.append(obj);
	    }
	    return sb.toString();
	}
	
	private static final String urlEncode(String str) {
	    try {
	        return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException(e);
	    }
	}
}
