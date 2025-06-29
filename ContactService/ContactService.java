package com.warnercloud.Service;

import com.warnercloud.Model.Contact;

import java.util.HashMap;

public class ContactService {
    private final HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())){
            throw new IllegalArgumentException("Contact already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) {
        getContact(contactID).setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        getContact(contactID).setLastName(lastName);
    }

    public void updateNumber(String contactID, String number) {
        getContact(contactID).setPhone(number);
    }

    public void updateAddress(String contactID, String address) {
        getContact(contactID).setAddress(address);
    }

    private Contact getContact(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        return contact;
    }
}
