package fr.inova.saxparser.parser;

import fr.inova.saxparser.handler.ConsoleErrorHandler;
import fr.inova.saxparser.handler.ContactsHandler;
import fr.inova.saxparser.model.Contact;
import fr.inova.saxparser.model.Contacts;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class ContactsSaxParser {

    private static final SAXParserFactory DEFAULT_SAX_PARSER_FACTORY = SAXParserFactory.newInstance();

    private ContactsSaxParser() {
    }

    public static List<Contact> parseXmlFile(final String filePath) throws Exception {
        var fileInputStream = new FileInputStream(filePath);
        var contacts = parseXml(fileInputStream);

        return contacts.getContacts();
    }

    private static Contacts parseXml(final InputStream inputStream) throws Exception {
        // Create a new SAX parser
        var saxParser = DEFAULT_SAX_PARSER_FACTORY.newSAXParser();

        // Recover XML reader + set it all handlers
        var xmlReader = saxParser.getXMLReader();

        var contactsHandler = new ContactsHandler();
        var consoleErrorHandler = new ConsoleErrorHandler(System.err);
        xmlReader.setContentHandler(contactsHandler);
        xmlReader.setErrorHandler(consoleErrorHandler);

        // Create input source + set it default encoding to UTF-8
        var inputSource = new InputSource();
        inputSource.setByteStream(inputStream);
        inputSource.setEncoding(StandardCharsets.UTF_8.toString());

        // Parse XML
        xmlReader.parse(inputSource);

        return contactsHandler.getContacts();
    }
}
