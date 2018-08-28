package com.vinz;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("80001234");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\n Enter 6 to show the available functions");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n shutting down ..");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }
    private static void addNewContact(){
        System.out.println("Enter New contact name");
        String name = scanner.nextLine();
        System.out.println("Enter New number");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println(newContact + " new contact is added: name = " + name+ " , Phone number is "+number);
        }else{
            System.out.println(" Cannot add name "+ name+ " it already exists");
        }
    }
    public static void removeContact() {
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact doesnt exist");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully created");
        } else {
            System.out.println("error deleting");
        }
    }

    public static void queryContact() {
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact doesnt exist");
            return;
        }

        System.out.println("Name: "+ existingContactRecord.getName()+ " phone number is "+existingContactRecord.getPhoneNumber());

    }
    public static void updateContact(){
        System.out.println("enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact doesnt exist");
            return;
        }
        System.out.println(" Enter the new name");
        String newName = scanner.nextLine();
        System.out.println("Enter contact info of updated name");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("successfully updated record");
        }else{
            System.out.println("error updating the contact");
        }
    }
    private static void startPhone(){
        System.out.println(" Starting the phone ....");
    }
    private static void printActions(){
        System.out.println("\n Available actions: \nEnter a selection");
        System.out.println(" 0 - To shut down \n"+
                           " 1 - To print contacts\n"+
                           " 2 - To add a contact\n"+
                           " 3 - To update a contact\n"+
                           " 4 - To remove a contact\n"+
                           " 5 - To query a contact\n"+
                           " 6 - To print list of available functions\n");
        System.out.println(" Choose what you want to do ");
    }
}
