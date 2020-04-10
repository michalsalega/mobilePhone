package com.michalek;

import java.util.Scanner;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        int choice;
        while(!quit){
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    printInstructions();
                    break;
            }

        }
    }
    private static void printContacts(){
        mobilePhone.printContacts();
    }



    private static void modifyContact(){
        String contactName;
        System.out.println("Enter contact to modify name: ");
        contactName = scanner.nextLine();
        int position = searchContact(contactName);

        System.out.println("Enter a new contact name: ");
        contactName = scanner.nextLine();
        System.out.println("Enter the new contact's number: ");
        int newNumber = scanner.nextInt();
        scanner.nextLine();

        mobilePhone.modifyContact(mobilePhone.getListOfContacts().get(position), new Contact(contactName, newNumber));
    }

    private static boolean addContact(){
        String contactName;
        System.out.println("Enter contact name: ");
        contactName = scanner.nextLine();
        if(searchContact(contactName) >= 0){
            System.out.println("You already have that contact");
            return false;
        }
        System.out.println("Enter phone number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        mobilePhone.addContact(new Contact(contactName, number));
        return true;
    }

    private static void removeContact(){
        String contactName;
        System.out.println("Enter contact name: ");
        contactName = scanner.nextLine();
        int position = searchContact(contactName);
        if(position == -1){
            System.out.println("You dont have such a contact");
        }
        mobilePhone.removeItem(mobilePhone.getListOfContacts().get(position));
    }

     private static void findContact(){
        String contactName;
        System.out.println("Enter contact name: ");
        contactName = scanner.nextLine();
        int position = searchContact(contactName);
        if(position == -1){
            System.out.println("You dont have such a contact");
        }
        System.out.println(mobilePhone.getListOfContacts().get(position).getContactNumber());
    }

    private static int searchContact(String name){
        int position = -1;
        for(Contact contact : mobilePhone.getListOfContacts()){
            if(name.equals(contact.getContactName())){
                position = mobilePhone.getListOfContacts().indexOf(contact);
            }
        }
        return position;
    }

    private static void printInstructions(){
        System.out.println("0 - quit\n1 - print list of contacts\n2 - update existing contact\n" +
                            "3 - add contact\n4 - remove contact\n5 - find contact");
    }
}

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with Contact objects only.