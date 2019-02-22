package Notepad.Record;

import java.util.Scanner;

public class Record {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    public void Record(String first, String last, String phNumber) {
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = phNumber;
    }

    public void setFirstName(String NewFirstName) {
        this.firstName = NewFirstName;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Record populateRecord() {

        Scanner input = new Scanner(System.in);
        System.out.println("The record is empty. Please provide details.");

        System.out.println("First name: ");
        String firstName = input.nextLine();

        System.out.println("Last name: ");
        String lastName = input.nextLine();

        System.out.println("Phone number: ");
        String phoneNumber = input.nextLine();

        return this;

    }

    public String toString() {
        String res;

        res = firstName + " " + lastName + " " + phoneNumber + " " + email + " " + address;

        return res;
    }

    public void showRecord(){

        String textRecord = this.toString();

        System.out.println(textRecord);
    }

}