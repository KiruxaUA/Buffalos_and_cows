package com.company;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] hiddenNumbersList = new String[]{"1234", "2134", "3124", "4123", "3214", "3421", "1342", "2431", "3412",
                "1432", "2341", "9876", "9876", "9678", "9768", "8123", "8325", "4897", "6478"};
        String hiddenNumber = hiddenNumbersList[(int) (Math.random() * hiddenNumbersList.length)];
        String usersInput = "";
        int cows = 0, buffalos = 0, attempts = 0;
        while (true) {
            while (usersInput.length() != 4) {
                System.out.print("Input your number: ");
                usersInput = scanner.next().trim();
                if (usersInput.length() == 4) {
                    break;
                }
                System.out.println("Invalid input (4-digit number required)!");
                System.out.println("\n\n");
            }
            if (usersInput.equals(hiddenNumber)) {
                attempts++;
                break;
            }
            else {
                for (int i = 0; i < usersInput.length(); i++) {
                    if (usersInput.charAt(i) == hiddenNumber.charAt(i)) {
                        buffalos++;
                    }
                    if (hiddenNumber.contains(usersInput.subSequence(i, i + 1))) {
                        cows++;
                    }
                }
                System.out.println("Your number have: " + buffalos + " buffalos and " + cows + " cows");
                attempts++;
                System.out.print("\n\n");
                usersInput = "";
                buffalos = cows = 0;
            }
        }
        System.out.println("Congratulations! You guessed the number from " + attempts + " attempt");
    }
}
