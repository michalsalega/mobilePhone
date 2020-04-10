package com.michalek;

 class Contact {
    private String contactName;
    private int contactNumber;

     Contact(String contactName, int contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

     String getContactName() {
        return contactName;
    }

     int getContactNumber() {
        return contactNumber;
    }


}
