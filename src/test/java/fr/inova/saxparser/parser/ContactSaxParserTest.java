package fr.inova.saxparser.parser;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static fr.inova.saxparser.parser.ContactSaxParser.parseXmlFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactSaxParserTest {

    @Test
    public void parseXmlFile_validFilePath_xmlParsed() throws Exception {
        // Given
        var filePath = ContactSaxParserTest.class.getClassLoader().getResource("contacts.xml").getPath();

        // When
        var contacts = parseXmlFile(filePath);

        // Then
        assertEquals(2, contacts.size());

        var contact = contacts.get(0);
        assertEquals("1", contact.getId());
        assertEquals("David", contact.getName());
        assertEquals("FRALEY", contact.getLastName());
        assertEquals(1, contact.getContacts().getContacts().size());
    }

    @Test
    public void parseXmlFile_invalidFilePath_fileNotFoundExceptionThrown() {
        // Given
        var filePath = "fake";

        // When + Then
        assertThrows(FileNotFoundException.class, () -> parseXmlFile(filePath));
    }
}
