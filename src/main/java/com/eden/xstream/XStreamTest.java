package com.eden.xstream;

import com.eden.jaxb.Customer;
import com.thoughtworks.xstream.XStream;

public class XStreamTest {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("eden");
		customer.setAge(1);
		
		XStream xStream = new XStream();
		String s1 = xStream.toXML(customer);
		System.out.println(s1);
		xStream.toXML(customer, System.out);
	}

}
