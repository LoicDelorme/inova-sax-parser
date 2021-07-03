package fr.inova.saxparser.handler;

import fr.inova.saxparser.model.Contact;
import fr.inova.saxparser.model.Contacts;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class ContactsHandler implements ContentHandler {

    private StringBuilder currentValue;

    private List<Contact> currentContacts;

    private Contacts contacts;

    public Contacts getContacts() {
        return this.contacts;
    }

    @Override
    public void setDocumentLocator(final Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
        this.currentValue = new StringBuilder();
        this.currentContacts = new ArrayList<>();
        this.contacts = new Contacts();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(final String prefix, final String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(final String prefix) throws SAXException {
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException {
        // Reset currentValue to empty
        this.currentValue.setLength(0);

        if (qName.equalsIgnoreCase("contacts")) {
            var latestContact = this.latestContact();
            if (latestContact != null) {
                latestContact.setContacts(new Contacts());
            }
        }

        if (qName.equalsIgnoreCase("contact")) {
            var contact = new Contact();
            contact.setId(atts.getValue("id"));

            var latestContact = this.latestContact();
            if (latestContact != null) {
                latestContact.getContacts().addContact(contact);
            } else {
                this.contacts.addContact(contact);
            }
            this.pushContact(contact);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            this.latestContact().setName(this.currentValue.toString());
        }

        if (qName.equalsIgnoreCase("lastName")) {
            this.latestContact().setLastName(this.currentValue.toString());
        }

        if (qName.equalsIgnoreCase("contact")) {
            this.popContact();
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        this.currentValue.append(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(final char[] ch, final int start, final int length) throws SAXException {
    }

    @Override
    public void processingInstruction(final String target, final String data) throws SAXException {
    }

    @Override
    public void skippedEntity(final String name) throws SAXException {
    }

    private void pushContact(final Contact contact) {
        this.currentContacts.add(contact);
    }

    private void popContact() {
        this.currentContacts.remove(this.currentContacts.size() - 1);
    }

    private Contact latestContact() {
        if (this.currentContacts.isEmpty()) {
            return null;
        }

        return this.currentContacts.get(this.currentContacts.size() - 1);
    }
}
