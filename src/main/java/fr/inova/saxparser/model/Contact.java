package fr.inova.saxparser.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {

    @XmlAttribute
    private String id;

    private String name;

    private String lastName;

    private Contacts contacts;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public void setContacts(final Contacts contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
