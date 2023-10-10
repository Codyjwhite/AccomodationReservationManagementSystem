import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private Address mailingAddress;
    private String email;
    private String phoneNumber;
    private List<Reservation> reservationList;

    public Account(String accountNumber, Address mailingAddress, String email, String phoneNumber) {
        this.reservationList = new ArrayList<>();
        this.accountNumber = accountNumber;
        this.mailingAddress = mailingAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservationList);
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

    private boolean isValidEmail(String email){
        //check if format requirements are met
        return true;
    }
    private boolean isValidPhoneNumber(String phoneNumber){
        //check if format requirements are met
        return true;
    }

    //addReservation adds Reservation to reservationList
    public void addReservation(Reservation reservation){
        /*
        take reservation and add it to reservationList
         */
    }

    //provide UI with ability to output data to the screen
    public String toString(){return "String";}
}
