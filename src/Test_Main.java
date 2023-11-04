import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test_Main {
    public static void main(String[] args) throws IOException, ObjectNotFoundException {
        Manager manager = new Manager();
        manager.loadAccounts();
        manager.printAccountList();

        testCreateAccount();
        //testLoadAccount();
        testCreateReservation();





        //manager.loadAccounts();
        //test deleteAccount
        //manager.deleteAccount("A000000002");
        //test deleteReservation
        //manager.deleteReservation("A000000002", "O1234567892");
        //Test updateAccount
        //manager.updateAccount("A000000001", null, null, null, null, null, null, null);

    }

    private static void printAccountList() {
        Manager testManger = new Manager();
        //TODO Used for testing
        Map<String, Account> accountList = testManger.getAccountList();
        for (Map.Entry<String, Account> entry : accountList.entrySet()) {
            String accountNumber = entry.getKey();
            Account currentAccount = entry.getValue();
            System.out.println(accountNumber);
            System.out.println(currentAccount.toString());
            System.out.println(currentAccount.getFilePath());
        }
    }



    // testCreateAccount will create 5 accounts adding them to the hashmap and then writing them to file before displaying accountNumber, object contents, and filePath.
    private static void testCreateAccount() throws InvalidDirectoryException {

        Manager testManager = new Manager();

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
    private static void testCreateReservation() throws InvalidDirectoryException {

        Manager testManager = new Manager();
        // Call the addReservationToAccount method with test data for a Hotel reservation
        testManager.addReservationToAccount(
                "A000000001",  // accountNumber
                "H1234567899",  // reservationNumber
                new Date(),  // startDate
                5,  // strayDuration
                2,  // numberOfBeds
                1,  // numberOfBedrooms
                1,  // numberOfBathrooms
                850,  // lodgingSize
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
                "HotelLand",  // mailCountry
                Manager.resType.Hotel  // reservation type
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
                "HotelLand",  // mailCountry
                Manager.resType.Hotel  // reservation type
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
                "CabinLand",  // mailCountry
                Manager.resType.Cabin  // reservation type
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
                "HouseLand",  // mailCountry
                Manager.resType.House  // reservation type
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
                "HotelVille",
                Manager.resType.Hotel
        );
    }

    // testLoadAccount will load all account and reservations in directory and display contents
    private static void testLoadAccount() throws IOException {
        Manager testManager = new Manager();

        testManager.loadAccounts();
        //Confirming account are added and stored
        printAccountList();
    }

}


