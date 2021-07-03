package fr.inova.saxparser.model;

import java.util.ArrayList;
import java.util.List;

public class Contacts {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return this.contacts;
    }

    public void addContact(final Contact contact) {
        this.contacts.add(contact);
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
