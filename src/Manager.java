import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    public String directoryPath = " ";
    public Map<Account, List<Reservation>> accountList = new HashMap<>();


    //loadAccounts loads in stored data into a HashMap to be used by other methods
    public void loadAccounts(){
       /*
        Create a file object using the directoryPath
        dataFile = new File(directoryPath)

        Check if file exist handling error if check returns false
        if !dataFile
            error handle

         create array of accounts
         File[] Accounts = files found within datafile

         for account in accounts
            load data from account json
            create account object with loaded json data

            resDirect = account reservation directory
            File[] = resFiles = reservation files in resDirect

            List<Reservation> reservations = new ArrrayList<>
            for resFile in resDirect
                create reservation object with json data
                reservations.add(created reservation object)

           accountList.put(current account object, current reservation list)
        */
    }

    //addAccount creates an Account object and adds it to account list
    public void addAccount(String street, String city, String state, String zipCode, String country, String email, String phoneNumber){
        /*
        Address accountAddress = new address(String street,String city,String state,String zipCode,String country)
        Account newAccount = new Account(accountAddress, email, phoneNumber)

        create an empty reservations list

        add new account and empty list to account list

         */
    }

    //updateAccount takes in a specific Account object to update its parameters
    public void updateAccount(Account account){}

    //addReservationToAccount add a created Reservation object to a specific Account in accountList
    public void addReservationToAccount(String accountNumber){}

    //Sets status of the reservation to complete
    public void completeReservation(String accountNumber, String reservationNumber){}

    //Sets status of the reservation to canceled
    public void cancelReservation(String accountNumber, String reservationNumber) {}

    //upddateReservation takes in a specific Reservation object to update its parameters
    public void updateReservation(String accountNumber, String reservationNumber) {}

    //returns a double representing a Reservation's cost per night
    public Double pricePerNight(Reservation reservation) {return 0.0;}

    //returns a double representing a Reservation's total cost
    public Double TotalPrice(Reservation reservation) {return 0.0;}

}


