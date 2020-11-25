package com.ptm.main.common.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.ptm.main.entity.UserRole;

public class JAXBUtil {

	public static void jaxbToXML(JaxbContainer jaxbContainer) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(JaxbContainer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// To format XML
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// If we have JAXB annotated class
			jaxbMarshaller.marshal(jaxbContainer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void jaxbToXML(UserRole userRole) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserRole.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// To format XML
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// If we DO NOT have JAXB annotated class
			QName qName = new QName("userRole", "userRole");
			JAXBElement<UserRole> jaxbElement = new JAXBElement<UserRole>(qName, UserRole.class, userRole);
			jaxbMarshaller.marshal(jaxbElement, System.out);

			// If we have JAXB annotarzwuated class
			// jaxbMarshaller.marshal(userRole, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
