package dev.lpa;

import java.util.ArrayList;
public class MobilePhone {
    // write code here
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    private int findContact(Contact contact){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(contact.getName())){
                return i; // myContacts[i] is a Contact object!
            }
        }
        return -1;
    }

    private int findContact(String name){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(name)){
                return i; // myContacts[i] is a Contact object!
            }
        }
        return -1;
    }


    //Two Contact objects are equal if they have the same name.
    public boolean addNewContact(Contact contact){
        int index = findContact(contact);
        // This contact does not exist
        if(index < 0){
            myContacts.add(contact);
            return true;

            //This contact exists
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int index = myContacts.indexOf(oldContact);
        if(index >= 0 ){
            // oldContact exists and is updated.
            myContacts.set(index, newContact);
            return true;
        } else {
            // indexOf return -1 if the method can't find the match
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        if (myContacts.contains(contact)){
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }


    public Contact queryContact (String name){
        int index = findContact(name);
        if (index == -1) {
            return null;
        } else {
            return myContacts.get(index);
        }


    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < myContacts.size(); i++){
            String name = myContacts.get(i).getName();
            String phoneNumber = myContacts.get(i).getPhoneNumber();
            System.out.println((i+1) + ". " + name + " -> " + phoneNumber);
        }

    }

}