package com.eden.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBTest {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("eden");
		customer.setAge(1);

		File file = new File("D:\\jaxb-test.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(customer, file);
			marshaller.marshal(customer, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
