import java.util.Scanner;

public class InputProcessor {

    public static int getUserInput(String prompt, int min, int max) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        try {
            int inputValue = Integer.parseInt(userInput);

            if (inputValue < min || inputValue > max) {
                throw new IllegalArgumentException("Input out of range.");
            }
            return inputValue;

        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
            System.out.println("Try again.");
            return getUserInput(prompt, min, max); //calls itself until valid input is given

        }
    }

    
    public static int getUserInput(String prompt, int max) {
        int min = 0;
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        try {
            int inputValue = Integer.parseInt(userInput);

            if (inputValue < min || inputValue > max) {
                throw new IllegalArgumentException("Input out of range.");
            }
            return inputValue;

        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
            System.out.println("Try again.");
            return getUserInput(prompt, max); //calls itself until valid input is given

        }
    }
}