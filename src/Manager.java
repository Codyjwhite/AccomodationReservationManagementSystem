import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;



public class Manager {

    private final String directoryPath;

    //public enum resType {Hotel, Cabin, House}

    public static Map<String, Account> accountList;

    public Manager() {
        this.directoryPath = "C:\\Users\\codyj\\OneDrive\\Desktop\\Accommodation_Accounts";
        this.accountList = new HashMap<>();
    }

    public void printAccountList() {
        //TODO Used for testing
        for (Map.Entry<String, Account> entry : accountList.entrySet()) {
            String accountNumber = entry.getKey();
            Account currentAccount = entry.getValue();
            System.out.println(accountNumber + "\n");
            System.out.println(currentAccount.toString() + "\n");
            printReservation(currentAccount);

        }
    }
    public void printReservation(Account account) {

        for (Map.Entry<String, Reservation> entry : account.getReservations().entrySet()) {
            String reservationNumber = entry.getKey();
            Reservation reservation = entry.getValue();
            System.out.println(reservationNumber  + "\n");
            System.out.println(reservation.toString() + "\n");
        }
    }

    public Map<String, Account> getAccountList() {
        return accountList;
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
        //Load accounts into accountList
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

                    //Load reservations into account's list
                    File reservationFolder = new File(accFile, newAccount.getAccountNumber() + "-Reservations");

                    if(reservationFolder.exists() && reservationFolder.isDirectory()) {

                        File[] reservationFiles = reservationFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
                        if (reservationFiles != null) {
                            for (File resFile : reservationFiles) {

                                try (FileReader resReader = new FileReader(resFile)) {
                                    char resTypeIdent = resFile.getName().charAt(0);
                                    switch (resTypeIdent) {
                                        case 'H' -> {
                                            //Creates a House object from json
                                            HotelReservation hotelReservation = reservationGson.fromJson(resReader,
                                                    HotelReservation.class);
                                            //newAccount.addReservation(hotelReservation);
                                            newAccount.getReservations().put(hotelReservation.getReservationNumber(), hotelReservation);
                                            break;

                                        }
                                        case 'C' -> {
                                            //Creates a Cabin object from json
                                            CabinReservation cabinReservation = reservationGson.fromJson(resReader,
                                                    CabinReservation.class);
                                            //newAccount.addReservation(cabinReservation);
                                            newAccount.getReservations().put(cabinReservation.getReservationNumber(), cabinReservation);
                                            break;


                                        }
                                        case 'O' -> {
                                            //Creates a House object from json
                                            HouseReservation houseReservation = reservationGson.fromJson(resReader,
                                                    HouseReservation.class);
                                            //newAccount.addReservation(houseReservation);
                                            newAccount.getReservations().put(houseReservation.getReservationNumber(), houseReservation);
                                            break;

                                        }
                                        default -> {
                                            throw new IOException();
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
        //Create new json file and empty directory for reservations
        String folderDirectory = directoryPath + "\\" + "Account-" + accountNumber;
        String newDirectory = folderDirectory + "\\" + accountNumber + ".json";
        String resDirectory = folderDirectory + "\\" + accountNumber + "-Reservations";

        Account newAccount = new Account(accountNumber, accountAddress, email, phoneNumber, newDirectory);

        //add new account and empty list to accountList
        accountList.put(accountNumber, newAccount);

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

    //TODO built for testing not meant for system functionality
//    public void deleteAccount(String accountNumber) {
//
//        //Finds and deletes Account and its associated directories
//        String folderDirectory = getAccountByNumber(accountNumber).getFilePath();
//        Path filePath = Paths.get(folderDirectory);
//
//        //Created a walkable path with the account's directory
//        try(Stream<Path> walk = Files.walk(filePath, FileVisitOption.FOLLOW_LINKS)) {
//            //Walks through the path in reverse deleting files/folders as it follows the path
//            walk.sorted(java.util.Comparator.reverseOrder()).forEach(file -> {
//                try {
//                    Files.delete(file);
//                }catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public Account getAccountByNumber(String accountNumber) throws ObjectNotFoundException {

        //Finds and returns account using accountNumber
        Account foundAccount = accountList.get(accountNumber);

        if (foundAccount == null) {
            throw new ObjectNotFoundException(accountNumber);
        }
        return foundAccount;
    }

    private Reservation getReservationByNumber(String accountNumber, String reservationNumber) {
        Account resAccount = getAccountByNumber(accountNumber);

        //create a list consists of the reservations attached to account
        Map<String, Reservation> accountReservations = resAccount.getReservations();

        for (Map.Entry<String, Reservation> entry : accountReservations.entrySet()) {

            if (entry.getKey().equals(reservationNumber)) {
                return entry.getValue();
            }
        }
        throw new ObjectNotFoundException(reservationNumber);
    }

    //updateAccount takes in a specific Account object to update its parameters
    public void updateAccount(String accountNumber, String newEmail, String newPhoneNumber, String street,
                                 String city, String state, String zipCode, String country) throws InvalidDirectoryException {


        //Check new parameters and update object
        try {
            Account updatedAccount = getAccountByNumber(accountNumber);
            updatedAccount.updateAccount(accountNumber, newEmail, newPhoneNumber, street, city, state, zipCode, country);
            String newDirectory = updatedAccount.getFilePath();
            //Creates json holding account objects
            try (FileWriter newAccountJson = new FileWriter(newDirectory)) {
                newAccountJson.write(updatedAccount.toString());

            } catch (IOException e) {
                throw new InvalidDirectoryException(newDirectory);
            }
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(accountNumber);
        }
    }


    //addReservationToAccount add a created Reservation object to a specific Account in accountList
    public void addReservationToAccount(String accountNumber, String reservationNumber, Date startDate,
                                        int strayDuration, int numberOfBeds, int numberOfBedrooms,
                                        float numberOfBathrooms, int lodgingSize, Reservation.resType reservationType, Boolean hasKitchenette,
                                        Boolean hasFullKitchen, Boolean hasLoft, int numOfFloors, String phyStreet,
                                        String phyCity, String phyState, String phyZipCode, String phyCountry,
                                        String mailStreet,
                                        String mailCity, String mailState, String mailZipCode, String mailCountry) throws ObjectNotFoundException, InvalidDirectoryException {

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

        String fileDirectory = directoryPath + "\\" + "Account-" + accountNumber  + "\\" + accountNumber
                + "-Reservations" + "\\" + reservationNumber + ".json";

        switch (reservationType) {

            case Hotel -> {
                 newRes = new HotelReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, reservationType, fileDirectory,
                        hasKitchenette);
            }
            case Cabin -> {
                newRes = new CabinReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, reservationType, fileDirectory,
                        hasFullKitchen, hasLoft);
            }
            case House -> {
                newRes = new HouseReservation(accountNumber, reservationNumber, mailAddress, phyAddress,
                        startDate, strayDuration, numberOfBeds, numberOfBedrooms, numberOfBathrooms, lodgingSize, reservationType, fileDirectory,
                        numOfFloors);
            }
        }
        resAccount.addReservation(newRes);

        //Write and store reservation json
        try (FileWriter newResJson = new FileWriter(fileDirectory)) {
            newResJson.write(newRes.toString());
        } catch (IOException e) {
            throw new InvalidDirectoryException(fileDirectory);
        }
    }

    public void deleteReservation(String accountNumber, String reservationNumber) throws IOException {

        Account resAccount = getAccountByNumber(accountNumber);
        resAccount.removeReservation(getReservationByNumber(accountNumber, reservationNumber));
        //Deletes Reservation json from directory
        Path filePath = Paths.get(getReservationByNumber(accountNumber, reservationNumber).getFilePath());
        Files.delete(filePath);
    }


    //Sets status of the reservation to complete
    public void completeReservation (String accountNumber, String reservationNumber) throws InvalidDirectoryException {

        //Account userAccount = getAccountByNumber(accountNumber);
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber);

        userReservation = userReservation.completeReservation();

        Gson canceledGson = new Gson();
        try(FileWriter writer = new FileWriter((userReservation.getFilePath()))) {
            writer.write(canceledGson.toJson(userReservation));
        } catch (IOException e) {
            throw new InvalidDirectoryException(userReservation.getFilePath());
        }

        }

            //Sets status of the reservation to canceled
    public void cancelReservation (String accountNumber, String reservationNumber) throws InvalidDirectoryException {

        //Account userAccount = getAccountByNumber(accountNumber);
        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber);

        userReservation = userReservation.cancelReservation();

        Gson canceledGson = new Gson();
        try(FileWriter writer = new FileWriter((userReservation.getFilePath()))) {
            writer.write(canceledGson.toJson(userReservation));
        } catch (IOException e) {
            throw new InvalidDirectoryException(userReservation.getFilePath());
        }

    }

    //updateReservation takes in a specific Reservation object to update its parameters
    public void updateReservation (String accountNumber, String reservationNumber, Date startDate,
            int stayDuration, int numberOfBeds, int numberOfBedrooms,
            float numberOfBathrooms, int lodgingSize, Boolean hasKitchenette,
                    Boolean hasFullKitchen, Boolean hasLoft,int numOfFloors, String phyStreet,
                    String phyCity, String phyState, String phyZipCode, String phyCountry, String mailStreet,
                    String mailCity, String mailState, String mailZipCode, String mailCountry,
                    boolean updateHasKitchenette, boolean updateHasFullKitchen, boolean updateHasLoft) {

        try {
            Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber);
            System.out.println(userReservation.getReservationNumber());
            Reservation.resType reservationType = userReservation.getReservationType();
            System.out.println(userReservation.toString());
            switch (reservationType) {
                case Hotel -> {
                    ((HotelReservation) userReservation).updateReservation(accountNumber, reservationNumber, startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                            numberOfBathrooms, lodgingSize, reservationType, phyStreet, phyCity, phyState, phyZipCode, phyCountry, mailStreet,
                            mailCity, mailState, mailZipCode, mailCountry, updateHasKitchenette);
                }

                case Cabin -> {
                    ((CabinReservation) userReservation).updateReservation(accountNumber, reservationNumber, startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                            numberOfBathrooms, lodgingSize, reservationType, phyStreet, phyCity, phyState, phyZipCode, phyCountry, mailStreet,
                            mailCity, mailState, mailZipCode, mailCountry, updateHasFullKitchen, updateHasLoft);
                }

                case House -> {
                    ((HouseReservation) userReservation).updateReservation(accountNumber, reservationNumber, startDate, stayDuration, numberOfBeds, numberOfBedrooms,
                            numberOfBathrooms, lodgingSize, reservationType, phyStreet, phyCity, phyState, phyZipCode, phyCountry, mailStreet,
                            mailCity, mailState, mailZipCode, mailCountry, numOfFloors);
                }

            }

            String fileDirectory = directoryPath + "\\" + "Account-" + accountNumber  + "\\" + accountNumber
                    + "-Reservations" + "\\" + reservationNumber + ".json";
            try (FileWriter newResJson = new FileWriter(fileDirectory)) {
                newResJson.write(userReservation.toString());
            } catch (IOException e) {
                throw new InvalidDirectoryException(fileDirectory);
            }

        } catch (ObjectNotFoundException | InvalidDirectoryException e) {
            throw new ObjectNotFoundException(reservationNumber, "Reservation number does not exist or is incorrect");
        }
    }

        //returns a double representing a Reservation's cost per night
    public Double pricePerNight (String accountNumber, String reservationNumber){


        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber);


        return userReservation.pricePerNight();
    }

            //returns a double representing a Reservation's total cost
    public Double TotalPrice (String accountNumber, String reservationNumber){


        Reservation userReservation = getReservationByNumber(accountNumber, reservationNumber);

        return userReservation.TotalPrice();
            }

        }