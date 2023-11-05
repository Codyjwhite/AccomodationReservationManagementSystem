import com.google.gson.Gson;

import java.beans.Transient;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Account {

    private final String accountNumber;
    private Address mailingAddress;
    private String email;
    private String phoneNumber;
    private String filePath;
    private transient Map<String, Reservation> reservationList;

    //Variable used to handle the email validation
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(emailRegex);

    //Varibles used to handle phone number validation
    private static final String phoneRegrex = "^(\\(\\d{3}\\)\\s?|\\d{3}[-\\s]?)\\d{3}[-\\s]?\\d{4}$";
    private static final Pattern phonePatten = Pattern.compile(phoneRegrex);

    public Account(String accountNumber, Address mailingAddress, String email, String phoneNumber, String filePath) {
        this.reservationList = new HashMap<String, Reservation>();
        this.accountNumber = accountNumber;
        this.mailingAddress = mailingAddress;
        this.filePath = filePath;


        if(this.isValidEmail(email)){
            this.email = email;
        }
        else {
            throw new InvalidFormatException("Format should be : email@domain.xxx");
        }

        if(this.isValidPhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new InvalidFormatException("Format should be 123-456-7890");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public  Map<String, Reservation> getReservations() {

        if(reservationList == null) {
            reservationList = new HashMap<String, Reservation>();
        }

        return reservationList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setMailingAddress(Address newMailingAddress) {
        this.mailingAddress = newMailingAddress;
    }
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
    public void setEmailAddress(String newEmail) {
        this.email = newEmail;
    }
    public void setFilePath(String filePath) {this.filePath = filePath;}

    private boolean isValidEmail(String email){
        //check if format requirements are met
        if(email == null) {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPhoneNumber(String phoneNumber){
        //check if format requirements are met
        if(phoneNumber == null) {
            return false;
        }
        Matcher matcher = phonePatten.matcher(phoneNumber);
        return matcher.matches();
    }

    //addReservation adds Reservation to reservationList
    public void addReservation(Reservation reservation){

        if(reservationList == null) {
            reservationList = new HashMap<String, Reservation>();
        }

        this.reservationList.put(reservation.getReservationNumber(), reservation);

    }
    public void removeReservation(Reservation reservation) {
        this.reservationList.remove(reservation);
    }

    public void updateAccount(String accountNumber, String newEmail, String newPhoneNumber, String street,
                              String city, String state, String zipCode, String country) {
        //Method used to update account objects
        try {

            if (newEmail != null) {
                this.email = newEmail;
            }
            if (newPhoneNumber != null) {
                this.phoneNumber= newPhoneNumber;
            }
            if (street != null || city != null || state != null || zipCode != null || country != null) {
                this.mailingAddress.updateAddress(street, city, state, zipCode, country);
            }

        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(accountNumber,"account number does not exist or is incorrect");
        }

    }

    //provide UI with ability to output data to the screen
    public String toString(){
        Gson newJsonFile = new Gson();
        return newJsonFile.toJson(this);}
}
