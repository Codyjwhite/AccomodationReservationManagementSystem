import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Account {

    private String accountNumber;
    private Address mailingAddress;
    private String email;
    private String phoneNumber;
    private List<Reservation> reservationList;


    //Variable used to handle the email validation
    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern emailPattern = Pattern.compile(emailRegex);

    //Varibles used to handle phone number validation
    private static final String phoneRegrex = "^(\\(\\d{3}\\)\\s?|\\d{3}[-\\s]?)\\d{3}[-\\s]?\\d{4}$";
    private static final Pattern phonePatten = Pattern.compile(phoneRegrex);

    public Account(String accountNumber, Address mailingAddress, String email, String phoneNumber) {
        this.reservationList = new ArrayList<>();
        this.accountNumber = accountNumber;
        this.mailingAddress = mailingAddress;


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

    public List<Reservation> getReservations() {
        return reservationList;
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

        this.reservationList.add(reservation);

    }

    //provide UI with ability to output data to the screen
    public String toString(){
        Gson newJsonFile = new Gson();
        return newJsonFile.toJson(this);}
}
