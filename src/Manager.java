import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Manager {

    private String directoryPath;

    public enum resType {Hotel, Cabin, House}

    private Map<String, Account> accountList;

    public Manager() {
        this.directoryPath = "C:\\Users\\codyj\\OneDrive\\Desktop\\Accommodation_Accounts";
        this.accountList = new HashMap<>();
    }

        public void printAccountList() {

        for (Map.Entry<String, Account> entry: accountList.entrySet()) {
            String accountNumber = entry.getKey();
            Account currentAccount = entry.getValue();
            System.out.println(currentAccount.toString());
            //TODO remove below line before submission
            for(Reservation res : currentAccount.getReservations()) {
                System.out.println(res.getReservationNumber() + " loaded");
            }

        }

    }
    //loadAccounts loads in stored data into a HashMap to be used by other methods
    public void loadAccounts() throws IOException {
        //Create a file object using the directoryPath
        File dataFile = new File(directoryPath);
        Gson accountGson = new Gson();
        Gson reservationGson = new Gson();

        //Check if file exist handling error if check returns false
        if (!dataFile.exists() || !dataFile.isDirectory()) {
            throw new InvalidDirectoryException(directoryPath);
        }
        //Load acccounts into accountList
        File[] files = dataFile.listFiles();
        assert files != null;
        for(File accFile :files) {
           File accountFolder = new File(accFile.getAbsolutePath());
           File[] accountJson = accountFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
           for(File jsonFile: accountJson) {
               try (FileReader reader = new FileReader(jsonFile)) {
                   //Creates Account object with loaded json
                   Account newAccount = accountGson.fromJson(reader, Account.class);
                   accountList.put(newAccount.getAccountNumber(), newAccount);
                   //TODO remove below line before submission
                   System.out.println(newAccount.getAccountNumber() + " loaded");

                   //Load reservations into account's list
                   File reservationFolder = new File(accFile, newAccount.getAccountNumber() + "-Reservations");

                   if(reservationFolder.exists() && reservationFolder.isDirectory()) {
                       //TODO REMOVE BELOW
                       System.out.println("Entering reservation folder: " + reservationFolder.getAbsolutePath());
                       File[] reservationFiles = reservationFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
                       if (reservationFiles != null) {
                           for (File resFile : reservationFiles) {
                               //TODO REMOVE BELOW
                               System.out.println("Processing reservation file: " + resFile.getName());
                               try (FileReader reader1 = new FileReader(resFile)) {
                                   char resTypeIdent = resFile.getName().charAt(0);
                                   switch (resTypeIdent) {
                                       case 'H' -> {
                                           //TODO REMOVE BELOW
                                           System.out.println("Loading hotel reservation from: " + resFile.getName());
                                           HotelReservation hotelReservation = reservationGson.fromJson(reader1,
                                                   HotelReservation.class);
                                           newAccount.getReservations().add(hotelReservation);
                                           System.out.println(hotelReservation.toString());
                                       }
                                       case 'C' -> {
                                           //TODO REMOVE BELOW
                                           System.out.println("Loading cabin reservation from: " + resFile.getName());
                                           CabinReservation cabinReservation = reservationGson.fromJson(reader1,
                                                   CabinReservation.class);
                                           newAccount.getReservations().add(cabinReservation);
                                           System.out.println(cabinReservation.toString());
                                       }
                                       case 'O' -> {
                                           //TODO REMOVE BELOW
                                           System.out.println("Loading house reservation from: " + resFile.getName());
                                           HouseReservation houseReservation = reservationGson.fromJson(reader1,
                                                   HouseReservation.class);
                                           newAccount.getReservations().add(houseReservation);
                                           System.out.println(houseReservation.toString());
                                       }
                                   }


                               }

                           }
                       }
                   }


               } catch (InvalidDirectoryException e) {
                   throw new InvalidDirectoryException(accFile.getAbsolutePath());
               }
           }
        }
    }

    //addAccount creates an Account object and adds it to account list
    public void addAccount(String accountNumber, String street, String city, String state, String zipCode,
                           String country, String email, String phoneNumber) throws InvalidDirectoryException {

        Address accountAddress = new Address(street, city, state, zipCode, country);
        Account newAccount = new Account(accountNumber, accountAddress, email, phoneNumber);

        //add new account and empty list to accountList
        accountList.put(accountNumber, newAccount);

        //Create new json file and empty directory for reservations
        String folderDirectory = directoryPath + "\\" + "Account-" + accountNumber;
        String newDirectory = folderDirectory + "\\" + accountNumber + ".json";
        String resDirectory = folderDirectory + "\\" + accountNumber + "-Reservations";

        //Creates folder that holds account json
        File folder = new File(folderDirectory);
        if (!folder.exists()) {
            if (!folder.mkdir()) {
                throw new InvalidDirectoryException(folderDirectory);
            }
        }
        //Creates folder that holds reservation jsons
        File resFolder = new File(resDirectory);
        if (!resFolder.exists()) {
            if (!resFolder.mkdir()) {
                throw new InvalidDirectoryException(resDirectory);
            }
        }
        //Creates json holding account objects
        try (FileWriter newAccountJson = new FileWriter(newDirectory)) {
            newAccountJson.write(newAccount.toString());
        } catch (IOException e) {
            throw new InvalidDirectoryException(newDirectory);
        }
    }

    public Account getAccountByNumber(String accountNumber) throws ObjectNotFoundException {

        Account foundAccount = accountList.get(accountNumber);
        if (foundAccount == null) {
            throw new ObjectNotFoundException(accountNumber);
        }
        return foundAccount;
    }

    private Reservation getReservationByNumber(String accountNumber, String reservationNumber) {

        Account resAccount = getAccountByNumber(accountNumber);

        //create a list consists of the reservations attached to account
        List<Reservation> accountReservations = resAccount.getReservations();

        for (Reservation res : accountReservations) {
            if (res.getReservationNumber().equals(reservationNumber)) {
                return res;
            }
        }
        throw new ObjectNotFoundException(reservationNumber);
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
    public void addReservationToAccount(String accountNumber, String reservationNumber, Date startDate,
                                           int strayDuration, int numberOfBeds, int numberOfBedrooms,
                                           float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette,
                                           Boolean hasFullKitchen, Boolean hasLoft,int numOfFloors, String phyStreet,
                                           String phyCity, String phyState, String phyZipCode, String phyCountry,
                                           String mailStreet,
                                           String mailCity, String mailState, String mailZipCode, String mailCountry,
                                           resType resType) throws ObjectNotFoundException, InvalidDirectoryException {

        // Retrieves account to add reservation to
        Account resAccount;
        try {
            resAccount = getAccountByNumber(accountNumber);
        } catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Creates address objects for reservation creation

        //Checks for null and creates mailing address object (Not required for every reservation)
        Address mailAddress = null;
        if (mailStreet != null && mailCity != null && mailState != null && mailZipCode != null
                && mailCountry != null) {
            mailAddress = new Address(mailStreet, mailCity, mailState, mailZipCode, mailCountry);
        }

        //Checks and creates physical address or sets mailing address as physical address (required)
        Address phyAddress = null;
        if (phyStreet != null && phyCity != null && phyState != null && phyZipCode != null && phyCountry != null) {
            phyAddress = new Address(phyStreet, phyCity, phyState, phyZipCode, phyCountry);
        } else if (mailAddress != null) {
            phyAddress = mailAddress;
        }
        else {
            throw new PhysicalAddressRequiredException();
           }

        Reservation newRes = null;

        switch (resType) {

            case Hotel -> {
                 newRes = new HotelReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize,
                        hasKitchenette);
            }
            case Cabin -> {
                newRes = new CabinReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize,
                        hasFullKitchen, hasLoft);
            }
            case House -> {
                newRes = new HouseReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize,
                        numOfFloors);
            }
        }
        resAccount.addReservation(newRes);
        //String fileDirectory = directoryPath + "\\" + "Account-" + accountNumber  + "\\" + accountNumber + "-Reservations";
        String fileDirectory = directoryPath + "\\" + "Account-" + accountNumber  + "\\" + accountNumber
                + "-Reservations" + "\\" + reservationNumber + ".json";
        try (FileWriter newResJson = new FileWriter(fileDirectory)) {
            newResJson.write(newRes.toString());
        } catch (IOException e) {
            throw new InvalidDirectoryException(fileDirectory);
        }
    }


            //Sets status of the reservation to complete
    public void completeReservation (String accountNumber, String reservationNumber){
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

         call method to set reservation as complete
         */
            }

            //Sets status of the reservation to canceled
    public void cancelReservation (String accountNumber, String reservationNumber){
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

         call method to set reservation as canceled
         */
            }

            //updateReservation takes in a specific Reservation object to update its parameters
    public boolean updateReservation (String accountNumber, String reservationNumber, Date startDate,
            int strayDuration, int numberOfBeds, int numberOfBedrooms,
            float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette,
                    Boolean hasFullKitchen, Boolean hasLoft,int numOfFloors, String phyStreet,
                    String phyCity, String phyState, String phyZipCode, String phyCountry,
                    String mailStreet,
                    String mailCity, String mailState, String mailZipCode, String mailCountry){
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
    public Double pricePerNight (String accountNumber, String reservationNumber){
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

        price = Run method to return pricePerNight
         */

                return 0.0;
            }

            //returns a double representing a Reservation's total cost
    public Double TotalPrice (Reservation reservation){
        /*
        Account userAccount = getAccountByNumber(accountNumber)
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber)

        price = Run method to return totalPrice
         */

                return 0.0;
            }

        }


