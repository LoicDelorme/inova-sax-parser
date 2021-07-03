package fr.inova.saxparser.parser;

import fr.inova.saxparser.model.Contact;
import fr.inova.saxparser.model.Contacts;
import jakarta.xml.bind.JAXBContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public final class ContactSaxParser {

    private ContactSaxParser() {
    }

    public static List<Contact> parseXmlFile(final String filePath) throws Exception {
        var fileInputStream = new FileInputStream(filePath);
        var contacts = parseXml(fileInputStream);

        return contacts.getContacts();
    }

    private static Contacts parseXml(final InputStream inputStream) throws Exception {
        var jaxbContext = JAXBContext.newInstance(Contacts.class);
        var unmarshaller = jaxbContext.createUnmarshaller();
        var contacts = (Contacts) unmarshaller.unmarshal(inputStream);

        return contacts;
    }
}
