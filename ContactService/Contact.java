package com.warnercloud.Model;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        //check requirements when creating object
        if (contactID == null || contactID.length() > 10) throw new IllegalArgumentException("Contact ID must have a length of 10");
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException("First name must have a length of 10");
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException("Last name must have a length of 10");
        if (phone == null || !phone.matches("\\d{10}")) throw new IllegalArgumentException("Phone must consist of exactly 10 digits");
        if (address == null || address.length() > 30) throw new IllegalArgumentException("Address must have a length of 10");

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    //getters
    public String getContactID() {return contactID;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}

    //setters
    //check requirements when updating field
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException("First name must have a length of 10");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException("Last name must have a length of 10");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) throw new IllegalArgumentException("Phone must consist of exactly 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) throw new IllegalArgumentException("Address must have a length of 30");
        this.address = address;
    }
}
