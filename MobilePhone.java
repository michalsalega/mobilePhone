package com.michalek;

import java.util.ArrayList;

class MobilePhone {
    private ArrayList<Contact> listOfContacts;

     MobilePhone() {
        this.listOfContacts = new ArrayList<>();
    }

     ArrayList<Contact> getListOfContacts() {
        return listOfContacts;
    }

     boolean addContact(Contact newContact){
        if(this.searchContact(newContact) >= 0){
            System.out.println("You already have a contact with this name");
            return false;
        }
         this.listOfContacts.add(newContact);
        return true;
    }

     private int searchContact(Contact searchContact){
        return this.listOfContacts.indexOf(searchContact);
    }

     void modifyContact(Contact oldContact, Contact newContact){

        if(this.searchContact(oldContact) >= 0 && this.searchContact(newContact.getContactName()) == -1){
            this.listOfContacts.set(this.listOfContacts.indexOf(oldContact), newContact);
            System.out.println("Contact modified");
        }else{
            System.out.println("Cant add" + newContact.getContactName());
        }
    }

    private int searchContact(String name){
        int position = -1;
        for(Contact contact : this.listOfContacts){
            if(name.equals(contact.getContactName())){
                position = this.listOfContacts.indexOf(contact);
            }
        }
        return position;
    }


    void removeItem(Contact contactToRemove){
        if(this.searchContact(contactToRemove) >= 0){
            this.listOfContacts.remove(contactToRemove);
            System.out.println("Contact removed");
        }
    }

     void printContacts(){
        for(Contact contact : this.listOfContacts){
            System.out.println(contact.getContactName() + " " + contact.getContactNumber() + "\n");
        }
    }
}
