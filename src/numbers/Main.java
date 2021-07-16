package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        intro();

        String number;

        do {
            System.out.print("\nEnter a request: ");
            number = scanner.nextLine();

            // if 0 then quit
            if (number.equals("0")) {
                System.out.println();
                break;
            }

            // if null string
            if (Utility.isNullString(number)) {
                System.out.println();
                intro();
                continue;
            }

            String[] array = number.split(" ");
            // check for numbers and parameters

            switch (array.length) {
                case 1:
                    Utility.detailedList(number);
                    break;
                case 2:
                    if (Utility.checkTwoNumbers(array)) {
                        Utility.iterateNumbers(array);
                    }
                    break;
                default:
                    if (Utility.checkTwoNumbers(array)) {
                        if (Utility.checkProperties(array)) {
                            Utility.shortListWithProperties(array);
                        }
                    }
                    break;
            }
        } while (true);

        System.out.println("Goodbye!");
    }

    public static void intro() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }
}