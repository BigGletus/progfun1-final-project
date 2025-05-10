
public class Main {
    private static InventoryManager manager;
    
    public static void main(String[] args) {
        int choice;

        System.out.flush();
        manager = new InventoryManager();
        manager.initializeData();
        do {
            System.out.println("Welcome to Sowers Camping Emporium! How can I help you?");
            System.out.println("1. View Supply Catalogue");
            System.out.println("2. Make a Purchase");
            System.out.println("3. List Item Sold Out");
            System.out.println("4. Restock an Item");
            System.out.println("5. Exit");
            choice = InputProcessor.getUserInput("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    manager.viewItems();
                    break;
                case 2:
                    manager.sellItem();
                    break;
                case 3:
                    manager.sellOutItem();
                    break;
                case 4:
                    manager.restockItem();
                    break;
                case 5:
                    manager.saveData(manager.getAvailableItems(), "availableStock.txt");
                    manager.saveData(manager.getSoldOutItems(), "soldOutStock.txt");
                    System.out.println("We hope to have you again soon!");
                    break;
            }
        } while (choice != 5);
    }
}