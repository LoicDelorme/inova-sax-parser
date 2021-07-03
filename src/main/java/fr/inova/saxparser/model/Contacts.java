package fr.inova.saxparser.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "contacts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contacts {

    @XmlElement(name = "contact")
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public void setContacts(final List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
