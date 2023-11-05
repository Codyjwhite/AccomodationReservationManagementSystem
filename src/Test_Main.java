import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Test_Main {
    public static void main(String[] args) throws IOException, ObjectNotFoundException {

       //testCreateAccount();

       //testCreateReservation();

       //testUpdateAccount();

       //testUpdateReservations();

       //testCancelReservation();

       //testCompleteReservation();

       //testPricePerNight();

       //testTotalPrice();

       //showAccountReservations();
    }



    // testCreateAccount will create 5 accounts adding them to the hashmap and then writing them to file before displaying accountNumber, object contents, and filePath.
    public static void testCreateAccount() throws IOException {
        Manager testManager = new Manager();
        testManager.loadAccounts();

        //Adding Accounts
        // 1. Adding the first account
        testManager.addAccount("A000000001", "123 Main St", "Springfield", "IL", "62701", "USA", "john.doe@example.com", "123-456-7890");

        // 2. Adding the second account
        testManager.addAccount("A000000002", "456 Elm St", "Shelbyville", "IL", "62702", "USA", "jane.smith@example.com", "987-654-3210");

        // 3. Adding the third account
        testManager.addAccount("A000000003", "789 Maple St", "Ogdenville", "IL", "62703", "USA", "alice.jones@example.com", "555-444-3333");

        // 4. Adding the fourth account
        testManager.addAccount("A000000004", "101 Pine St", "North Haverbrook", "IL", "62704", "USA", "bob.brown@example.com", "222-111-0000");

        // 5. Adding the fifth account
        testManager.addAccount("A000000005", "202 Oak St", "Brockway", "IL", "62705", "USA", "carol.white@example.com", "666-777-8888");

        }

    // testCreateReservation will create 5 reservations adding them to various accounts create in testCreateAccount before displaying resNumber, object contents and filePath/
    public static void testCreateReservation() throws IOException {

        Manager testManager = new Manager();
        //testLoadAccount();
        testManager.loadAccounts();
        // Call the addReservationToAccount method with test data for a Hotel reservation


        testManager.addReservationToAccount(
                "A000000001",  // accountNumber
                "H1234567899",  // reservationNumber
                createdDateForTest(),  // startDate
                5,  // strayDuration
                2,  // numberOfBeds
                1,  // numberOfBedrooms
                1,  // numberOfBathrooms
                850,  // lodgingSize
                Reservation.resType.Hotel, // reservation type
                true,  // hasKitchenette
                null,  // hasFullKitchen (not applicable for Hotel)
                null,  // hasLoft (not applicable for Hotel)
                1,  // numOfFloors (default for Hotel)
                "123 Hotel St",  // phyStreet
                "Hotel City",  // phyCity
                "HS",  // phyState
                "12345",  // phyZipCode
                "HotelLand",  // phyCountry
                "123 Hotel St",  // mailStreet
                "Hotel City",  // mailCity
                "HS",  // mailState
                "12345",  // mailZipCode
                "HotelLand" // mailCountry
        );
        // Call the addReservationToAccount method with test data for a Hotel reservation
        testManager.addReservationToAccount(
                "A000000004",  // accountNumber
                "H1234567890",  // reservationNumber
                new Date(),  // startDate
                5,  // strayDuration
                2,  // numberOfBeds
                1,  // numberOfBedrooms
                1,  // numberOfBathrooms
                850,  // lodgingSize
                Reservation.resType.Hotel,   // reservation type
                true,  // hasKitchenette
                null,  // hasFullKitchen (not applicable for Hotel)
                null,  // hasLoft (not applicable for Hotel)
                1,  // numOfFloors (default for Hotel)
                "123 Hotel St",  // phyStreet
                "Hotel City",  // phyCity
                "HS",  // phyState
                "12345",  // phyZipCode
                "HotelLand",  // phyCountry
                "123 Hotel St",  // mailStreet
                "Hotel City",  // mailCity
                "HS",  // mailState
                "12345",  // mailZipCode
                "HotelLand" // mailCountry

        );

        // Call the addReservationToAccount method with test data for a Cabin reservation
        testManager.addReservationToAccount(
                "A000000001",  // accountNumber
                "C1234567891",  // reservationNumber
                new Date(),  // startDate
                7,  // strayDuration
                3,  // numberOfBeds
                2,  // numberOfBedrooms
                2,  // numberOfBathrooms
                1200,  // lodgingSize
                Reservation.resType.Cabin,  // reservation type
                null,  // hasKitchenette (not applicable for Cabin)
                true,  // hasFullKitchen
                true,  // hasLoft
                1,  // numOfFloors (default for Cabin)
                "456 Cabin Rd",  // phyStreet
                "Cabin Town",  // phyCity
                "CT",  // phyState
                "67890",  // phyZipCode
                "CabinLand",  // phyCountry
                "456 Cabin Rd",  // mailStreet
                "Cabin Town",  // mailCity
                "CT",  // mailState
                "67890",  // mailZipCode
                "CabinLand"  // mailCountry

        );

        // Call the addReservationToAccount method with test data for a House reservation
        testManager.addReservationToAccount(
                "A000000002",  // accountNumber
                "O1234567892",  // reservationNumber
                new Date(),  // startDate
                10,  // strayDuration
                4,  // numberOfBeds
                3,  // numberOfBedrooms
                3,  // numberOfBathrooms
                2000,  // lodgingSize
                Reservation.resType.House, // reservation type
                null,  // hasKitchenette (not applicable for House)
                null,  // hasFullKitchen (default for House)
                null,  // hasLoft (default for House)
                2,  // numOfFloors
                "789 House Ave",  // phyStreet
                "House City",  // phyCity
                "HC",  // phyState
                "11223",  // phyZipCode
                "HouseLand",  // phyCountry
                "789 House Ave",  // mailStreet
                "House City",  // mailCity
                "HC",  // mailState
                "11223",  // mailZipCode
                "HouseLand" // mailCountry

        );

        // Another Hotel reservation for the same account
        testManager.addReservationToAccount(
                "A000000004",  // accountNumber
                "H1234567893",  // reservationNumber
                new Date(),  // startDate
                4,  // strayDuration
                2,  // numberOfBeds
                1,  // numberOfBedrooms
                1,  // numberOfBathrooms
                800,  // lodgingSize
                Reservation.resType.Hotel,
                false,  // hasKitchenette
                null,  // hasFullKitchen (not applicable for Hotel)
                null,  // hasLoft (not applicable for Hotel)
                1,  // numOfFloors (default for Hotel)
                "101 Hotel Blvd",  // phyStreet
                "HotelVille",  // phyCity
                "HV",  // phyState
                "44556",  // phyZipCode
                "HotelVilleLand",  // phyCountry
                "101 Hotel Blvd",  // mailStreet
                "HotelVille",  // mailCity
                "HV",
                "12345",
                "HotelVille"
        );
    }
    //testUpdateAccount will change various attributes of multiple account while keeping others the same
    public static void testUpdateAccount() throws IOException {
        Manager testManager = new Manager();
        testManager.loadAccounts();

        // Update email and phone number for account A000000001
        testManager.updateAccount("A000000001", "newemail1@example.com", "555-0101", null, null, null, null, null);

        // Update mailing address for account A000000002
        testManager.updateAccount("A000000002", null, null, "123 New Street", "New City", "NC", "12345", "Newland");

        // Update email, phone number, and partial address (street, city, state) for account A000000003
        testManager.updateAccount("A000000003", "newemail3@example.com", "555-0303", "456 Another Rd", "Another City", "AC", null, null);

        // Update phone number and zip code for account A000000004
        testManager.updateAccount("A000000004", null, "555-0404", null, null, null, "67890", null);

        // Update country for account A000000005
        testManager.updateAccount("A000000005", null, null, null, null, null, null, "CountryVille");
         }
    //testUpdateReservation will update various attributes to reservations while keeping others the same
    public static void testUpdateReservations() throws IOException {
        Manager testManager = new Manager();
        testManager.loadAccounts();

        // Test call for updating a Hotel reservation
        try {
            testManager.updateReservation(
                    "A000000004", // accountNumber
                    "H1234567890", // reservationNumber
                    new Date(), // startDate
                    5, // stayDuration
                    2, // numberOfBeds
                    1, // numberOfBedrooms
                    1.0f, // numberOfBathrooms
                    850, // lodgingSize
                    true, // hasKitchenette
                    null, // hasFullKitchen (not applicable for Hotel)
                    null, // hasLoft (not applicable for Hotel)
                    -1, // numOfFloors (not applicable for Hotel)
                    "123 Hotel St", // phyStreet
                    "Hotel City", // phyCity
                    "HS", // phyState
                    "12345", // phyZipCode
                    "HotelLand", // phyCountry
                    "123 Hotel St", // mailStreet
                    "Hotel City", // mailCity
                    "HS", // mailState
                    "12345", // mailZipCode
                    "HotelLand", // mailCountry
                    true, // updateHasKitchenette
                    false, // updateHasFullKitchen (not applicable)
                    false // updateHasLoft (not applicable)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

// Test call for updating a Cabin reservation
        try {
            testManager.updateReservation(
                    "A000000001", // accountNumber
                    "C1234567891", // reservationNumber
                    new Date(), // startDate
                    7, // stayDuration
                    3, // numberOfBeds
                    2, // numberOfBedrooms
                    2.0f, // numberOfBathrooms
                    1200, // lodgingSize
                    null, // hasKitchenette (not applicable for Cabin)
                    true, // hasFullKitchen
                    true, // hasLoft
                    -1, // numOfFloors (not applicable for Cabin)
                    "456 Cabin Rd", // phyStreet
                    "Cabin Town", // phyCity
                    "CT", // phyState
                    "67890", // phyZipCode
                    "CabinLand", // phyCountry
                    "456 Cabin Rd", // mailStreet
                    "Cabin Town", // mailCity
                    "CT", // mailState
                    "67890", // mailZipCode
                    "CabinLand", // mailCountry
                    false, // updateHasKitchenette (not applicable)
                    true, // updateHasFullKitchen
                    true // updateHasLoft
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

// Test call for updating a House reservation
        try {
            testManager.updateReservation(
                    "A000000002", // accountNumber
                    "O1234567892", // reservationNumber
                    new Date(), // startDate
                    10, // stayDuration
                    4, // numberOfBeds
                    3, // numberOfBedrooms
                    3.0f, // numberOfBathrooms
                    2000, // lodgingSize
                    null, // hasKitchenette (not applicable for House)
                    null, // hasFullKitchen (not applicable for House)
                    null, // hasLoft (not applicable for House)
                    2, // numOfFloors
                    "789 House Ave", // phyStreet
                    "House City", // phyCity
                    "HC", // phyState
                    "11223", // phyZipCode
                    "HouseLand", // phyCountry
                    "789 House Ave", // mailStreet
                    "House City", // mailCity
                    "HC", // mailState
                    "11223", // mailZipCode
                    "HouseLand", // mailCountry
                    false, // updateHasKitchenette (not applicable)
                    false, // updateHasFullKitchen (not applicable)
                    false // updateHasLoft (not applicable)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    //testCancelReservation will set reservation to canceled and rewrite file to json
    public static void testCancelReservation() throws IOException {
        Manager testManager = new Manager();
        testManager.loadAccounts();
        String testAccNumber = "A000000001";
        String testResNumber = "H1234567899";
        Account testAccount = testManager.getAccountByNumber(testAccNumber);
        Reservation testReservation = testAccount.getReservations().get(testResNumber);
        System.out.println("Reservation before operation");
        System.out.println(testReservation.toString());
        testManager.cancelReservation(testAccNumber, testResNumber);
        System.out.println("Reservation after operation");
        System.out.println(testReservation.toString());
    }
    //testCancelReservation will set reservation to complete and rewrite file to json
    public static void testCompleteReservation() throws IOException {
        Manager testManager = new Manager();
        testManager.loadAccounts();
        String testAccNumber = "A000000001";
        String testResNumber = "C1234567891";
        Account testAccount = testManager.getAccountByNumber(testAccNumber);
        Reservation testReservation = testAccount.getReservations().get("H1234567899");
        System.out.println("Reservation before operation");
        System.out.println(testReservation.toString());
        testManager.completeReservation(testAccNumber, testResNumber);
        System.out.println("Reservation after operation");
        System.out.println(testReservation.toString());

    }
    //testPricePerNight will calculate reservations' price per night
    public static void testPricePerNight() throws IOException {

        Manager testManager = new Manager();
        testManager.loadAccounts();
        for (Map.Entry<String, Account> entry : testManager.getAccountList().entrySet()) {
            Account currentAccount = entry.getValue();
            for(Map.Entry<String, Reservation> resEntry : currentAccount.getReservations().entrySet()) {
                System.out.println(resEntry.getKey() + " price per night: $"
                        + testManager.pricePerNight(entry.getKey(), resEntry.getKey()) + "\n");

            }
        }
    }
    //testPricePerNight will calculate reservations' total price
    public static void testTotalPrice() throws IOException {

        Manager testManager = new Manager();
        testManager.loadAccounts();
        for (Map.Entry<String, Account> entry : testManager.getAccountList().entrySet()) {
            Account currentAccount = entry.getValue();
            for(Map.Entry<String, Reservation> resEntry : currentAccount.getReservations().entrySet()) {
                System.out.println(resEntry.getKey() + " Total Price: $"
                        + testManager.TotalPrice(entry.getKey(), resEntry.getKey()) + "\n");

            }
        }
    }
    // showAccountReservations will show toString data for all loaded account and reservations
    public static void showAccountReservations() throws IOException {
        //Loads and displays data from directory
        Manager testManager = new Manager();
        testManager.loadAccounts();
        testManager.printAccountList();

    }

    public static Date createdDateForTest() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 1);

        return calendar.getTime();


    }



}


