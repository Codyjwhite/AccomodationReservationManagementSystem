import java.util.ArrayList;
import java.util.List;

public class Account {

    public String accountNumber;
    public Address mailingAddress;
    public String email;
    public String phoneNumber;
    List<Reservation> reservationList = new ArrayList<>();

    public Account(Address mailingAddress, String email, String phoneNumber) {}

    //addReservation creates a Reservation and adds it to reservationList
    public void addReservation(Reservation reservation){}

    //editDetails allows the Account object's parameters to be modified
    public void editDetails(Address newMailingAddress, String newPhoneNumber, String newEmail){}

    //provide UI with ability to output data to the screen
    public String toString(){return "String";}
}
