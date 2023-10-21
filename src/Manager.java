import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private String directoryPath;

    private enum resType { Hotel, Cabin, House}
    private Map<Account, List<Reservation>> accountList;

    public Manager() {
        this.directoryPath = "C:\\Users\\codyj\\OneDrive\\Desktop\\Accommodation_Accounts";
        this.accountList = new HashMap<>();
    }

    public void testMethod() {
        int i = 1;
        for (Map.Entry<Account, List<Reservation>> entry: accountList.entrySet()) {
            Account currentAccount = entry.getKey();
            List<Reservation> currentReservation = entry.getValue();

            System.out.println(currentAccount.toString());
            ++i;
        }

    }
    //loadAccounts loads in stored data into a HashMap to be used by other methods
    public void loadAccounts() throws InvalidDirectoryException {
       /*
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
        //Create a file object using the directoryPath
        File dataFile = new File(directoryPath);

        //Check if file exist handling error if check returns false
        if (!dataFile.exists() || !dataFile.isDirectory()) {
            throw new InvalidDirectoryException(directoryPath);
        }
        //FIXME Continue loadACCOUNTS once json records can be created and stored
    }

    //addAccount creates an Account object and adds it to account list
    public void addAccount(String accountNumber, String street, String city, String state, String zipCode,
                           String country, String email, String phoneNumber){

        Address accountAddress = new Address(street,city,state,zipCode,country);
        Account newAccount = new Account(accountNumber, accountAddress, email, phoneNumber);

        //create an empty reservations list
        List<Reservation> accountReservation = new ArrayList<Reservation>();

        //add new account and empty list to accountList
        accountList.put(newAccount, accountReservation);
        //Create new json file and empty directory for reservations
    }

    private Account getAccountByNumber(String accountNumber) {
        /*
        iterate through the HashMap looking for Account with accountNumber

        if null
            return null
        else
            return foundAccount
         */

        return null;
    }

    private Reservation getReservationByNumber(String accountNumber, String reservationNumber){
        /*
        Account userAccount = getAccountByNumber(accountNumber)

        create a list consists of the reservations attached to account
        List<Reservation> userReservations = map.get(userAccount)

        for each reservation
            if reservationNumber == resID
                return reservation
            else
                return null
         */
        return null;
    }

    //updateAccount takes in a specific Account object to update its parameters
    public boolean updateAccount(String accountNumber, String newEmail, String newPhoneNumber, String street,
                                 String city, String state, String zipCode, String country){
        /*
        Account updatedAccount = getAccountByNumber(accountNumber)

        if updated account == null
            return false
        if newEmail != null
            run method to update account email
        if newPhoneNumber != null
            run method to update phoneNumber
        if street, city, state, zipcode, country != null
            create new address object
            run method to update address

        run methods to make the changes permanent
            if no exception
                return True
            if exception
                return False
         */
        return true;
    }

    //addReservationToAccount add a created Reservation object to a specific Account in accountList
    //TODO Break down this into smaller more readable methods
    public boolean addReservationToAccount(String accountNumber, String reservationNumber, LocalDate startDate,
                                           int strayDuration, int numberOfBeds, int numberOfBedrooms,
                                           float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette,
                                           Boolean hasFullKitchen, Boolean hasLoft,int numOfFloors, String phyStreet,
                                           String phyCity, String phyState, String phyZipCode, String phyCountry,
                                           String mailStreet,
                                           String mailCity, String mailState, String mailZipCode, String mailCountry,
                                           resType resType){
        /*
        Account resAccount = getAccountByNumber(accountNumber)

        if resAccount == null
            throw objectNotFoundException
        if resAccount != null
            if mailAddress parameters != null
                create new mailAddress object
            if physicalAddress parameters == null
                throw PhysicalAddressRequiredException
            else
                create physicalAddress object

            check reservation type
            if resType == (Hotel, Cabin, House)
                create reservation object
                add reservation to account in accountList

        run methods to make the changes permanent
        if no exception
            return True
        if exception
            return False

         */
        return true;
    }


    //Sets status of the reservation to complete
    public void completeReservation(String accountNumber, String reservationNumber){
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

         call method to set reservation as complete
         */
    }

    //Sets status of the reservation to canceled
    public void cancelReservation(String accountNumber, String reservationNumber) {
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

         call method to set reservation as canceled
         */
    }

    //updateReservation takes in a specific Reservation object to update its parameters
    public boolean updateReservation(String accountNumber, String reservationNumber, LocalDate startDate,
                                  int strayDuration, int numberOfBeds, int numberOfBedrooms,
                                  float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette,
                                  Boolean hasFullKitchen, Boolean hasLoft,int numOfFloors, String phyStreet,
                                  String phyCity, String phyState, String phyZipCode, String phyCountry,
                                  String mailStreet,
                                  String mailCity, String mailState, String mailZipCode, String mailCountry) {
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

         check parameters if != null
            run methods to update object
            if address need to be updated, create new address object

        run methods to make the changes permanent
        if no exception
            return True
        if exception
            return False
         */
        return true;
    }

    //returns a double representing a Reservation's cost per night
    public Double pricePerNight(String accountNumber, String reservationNumber) {
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

        price = Run method to return pricePerNight
         */

        return 0.0;}

    //returns a double representing a Reservation's total cost
    public Double TotalPrice(Reservation reservation) {
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

        price = Run method to return totalPrice
         */

        return 0.0;}

}


