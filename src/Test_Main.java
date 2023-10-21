public class Test_Main {
    public static void main(String[] args) throws InvalidDirectoryException {

        Manager manager = new Manager();

        manager.loadAccounts();

        // Assuming you have a Manager instance named manager

// Assuming you have a Manager instance named manager

// 1. Adding the first account
        manager.addAccount("A000000001", "123 Main St", "Springfield", "IL", "62701", "USA", "john.doe@example.com", "123-456-7890");

// 2. Adding the second account
        manager.addAccount("A000000002", "456 Elm St", "Shelbyville", "IL", "62702", "USA", "jane.smith@example.com", "987-654-3210");

// 3. Adding the third account
        manager.addAccount("A000000003", "789 Maple St", "Ogdenville", "IL", "62703", "USA", "alice.jones@example.com", "555-444-3333");

// 4. Adding the fourth account
        manager.addAccount("A000000004", "101 Pine St", "North Haverbrook", "IL", "62704", "USA", "bob.brown@example.com", "222-111-0000");

// 5. Adding the fifth account
        manager.addAccount("A000000005", "202 Oak St", "Brockway", "IL", "62705", "USA", "carol.white@example.com", "666-777-8888");

        manager.testMethod();

    }
}
