import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private ArrayList<String> availableItems = new ArrayList<>();
    private ArrayList<String> soldOutItems = new ArrayList<>();
    public static Scanner kb = new Scanner(System.in);

    private ArrayList<String> loadData(String filename) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException error) {
            System.out.println("Error loading stock: " + error.getMessage());
        }
        return data;
    }

    public void saveData(ArrayList<String> data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : data) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException error) {
            System.out.println("Error saving data: " + error.getMessage());
        }
    }

    public void initializeData() {
        availableItems = loadData("availableStock.txt");
        soldOutItems = loadData("soldOutStock.txt");
    }

    public void viewItems() {
        System.out.println("List of camping supplies: " + availableItems);
        System.out.println("Sold out camping supplies: " + soldOutItems);
    }

    public void sellItem() {
        this.viewItems();
        int index = InputProcessor.getUserInput("Select the item you wish to purchase", 1, availableItems.size()) - 1;
        System.out.println("You have succesfully purchased (a) " + availableItems.get(index) + "!");
    }

    public void sellOutItem() {
        this.viewItems();
        int index = InputProcessor.getUserInput("Select the item you wish to report out of stock", 1, availableItems.size()) - 1;
        String item = availableItems.get(index);
        availableItems.remove(index);
        soldOutItems.add(item);
        System.out.println("Thank you for reporting " + item + " as out of stock!");
    }

    public void restockItem() {
        this.viewItems();
        int index = InputProcessor.getUserInput("Select the item you wish to restock", 1, soldOutItems.size()) - 1;
        String item = soldOutItems.get(index);
        soldOutItems.remove(index);
        availableItems.add(item);
        System.out.println("Thank you for restocking " + item + "!");
    }

    public ArrayList<String> getAvailableItems() {
        return availableItems;
    }

    public ArrayList<String> getSoldOutItems() {
        return soldOutItems;
    }
}