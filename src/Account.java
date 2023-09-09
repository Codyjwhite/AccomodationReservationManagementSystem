import java.util.ArrayList;
import java.util.List;

public class Account {

    public String accountNumber;
    public Address mailingAddress;
    public String email;
    public String phoneNumber;
    List<Reservation> reservationList;

    public Account(String accountNumber, Address mailingAddress, String email, String phoneNumber) {
//        this.reservationList = new ArrayList<>();
//        this.accountNumber = accountNumber;
//        this.mailingAddress = mailingAddress;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }

    //addReservation adds Reservation to reservationList
    public void addReservation(Reservation reservation){
        /*
        take reservation and add it to reservationList
         */
    }

    public void setMailingAddress(Address newMailingAddress) {
       // this.mailingAddress = newMailingAddress;
    }
    public void setPhoneNumber(String newPhoneNumber) {
       // this.phoneNumber = newPhoneNumber;
    }
    public void setEmailAddress(String newEmail) {
        //this.email = newEmail;
    }

    //provide UI with ability to output data to the screen
    public String toString(){return "String";}
}
