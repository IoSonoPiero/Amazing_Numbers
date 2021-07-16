package numbers;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringJoiner;

public class Utility {
    public static void detailedList(String number) {
        // if not numeric
        if (!Utility.isNumeric(number)) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }

        BigInteger theNumber = new BigInteger(number);

        // if number less than 1
        if (Utility.isNotNatural(theNumber)) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }

        NumberFormat formatter = NumberFormat.getInstance();

        System.out.println();

        System.out.format("Properties of %s%n", formatter.format(theNumber.longValue()));
        System.out.format("\teven: %b%n", Utility.isEven(theNumber));
        System.out.format("\todd: %b%n", !Utility.isEven(theNumber));
        System.out.format("\tbuzz: %b%n", Utility.isBuzz(theNumber));
        System.out.format("\tduck: %b%n", Utility.isDuck(theNumber));
        System.out.format("\tpalindromic: %b%n", Utility.isPalindromic(number));
        System.out.format("\tgapful: %b%n", Utility.isGapful(number));
        System.out.format("\tspy: %b%n", Utility.isSpy(number));
        System.out.format("\tsquare: %b%n", Utility.isSquare(theNumber));
        System.out.format("\tsunny: %b%n", Utility.isSunny(theNumber));
        System.out.format("\tjumping: %b%n", Utility.isJumping(theNumber.toString()));
        System.out.format("\thappy: %b%n", Utility.isHappy(theNumber.toString()));
        System.out.format("\tsad: %b%n", !Utility.isHappy(theNumber.toString()));
    }

    public static void shortListWithProperties(String[] array) {
        // iterate continuously until you get a certain number of items with specified property
        String number = array[0];
        String[] properties = Arrays.copyOfRange(array, 2, array.length);

        // total number of properties per each number
        int totalProperties = properties.length;

        // total numbers to find for all the properties
        int totalNumbers = Integer.parseInt(array[1]);

        BigInteger theNumber = new BigInteger(number);

        int counter = 0;

        System.out.println();
        while (counter < totalNumbers) {
            int actualProperties = 0;
            for (String property : properties) {
                switch (property.toLowerCase(Locale.ROOT)) {
                    case "even":
                    case "-odd":
                        if (Utility.isEven(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "-even":
                    case "odd":
                        if (!Utility.isEven(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "buzz":
                        if (Utility.isBuzz(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "-buzz":
                        if (!Utility.isBuzz(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "duck":
                        if (Utility.isDuck(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "-duck":
                        if (!Utility.isDuck(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "palindromic":
                        if (Utility.isPalindromic(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "-palindromic":
                        if (!Utility.isPalindromic(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "gapful":
                        if (Utility.isGapful(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "-gapful":
                        if (!Utility.isGapful(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "spy":
                        if (Utility.isSpy(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "-spy":
                        if (!Utility.isSpy(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "square":
                        if (Utility.isSquare(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "-square":
                        if (!Utility.isSquare(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "sunny":
                        if (Utility.isSunny(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "-sunny":
                        if (!Utility.isSunny(theNumber)) {
                            actualProperties++;
                        }
                        break;
                    case "jumping":
                        if (Utility.isJumping(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "-jumping":
                        if (!Utility.isJumping(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "happy":
                    case "-sad":
                        if (Utility.isHappy(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                    case "-happy":
                    case "sad":
                        if (!Utility.isHappy(theNumber.toString())) {
                            actualProperties++;
                        }
                        break;
                }
                if (actualProperties == totalProperties) {
                    shortList(theNumber);
                    counter++;
                }
            }

            theNumber = theNumber.add(BigInteger.ONE);
        }

    }

    public static void shortList(BigInteger theNumber) {
        String number = theNumber.toString();
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.format("\t\t%s is ", formatter.format(theNumber.longValue()));

        StringJoiner sj = new StringJoiner(", ");

        if (Utility.isEven(theNumber)) {
            sj.add("even");
        } else {
            sj.add("odd");
        }

        if (Utility.isBuzz(theNumber)) {
            sj.add("buzz");
        }

        if (Utility.isDuck(theNumber)) {
            sj.add("duck");
        }
        if (Utility.isPalindromic(number)) {
            sj.add("palindromic");
        }

        if (Utility.isGapful(number)) {
            sj.add("gapful");
        }

        if (Utility.isSpy(number)) {
            sj.add("spy");
        }

        if (Utility.isSquare(theNumber)) {
            sj.add("square");
        }

        if (Utility.isSunny(theNumber)) {
            sj.add("sunny");
        }

        if (Utility.isJumping(theNumber.toString())) {
            sj.add("jumping");
        }

        if (Utility.isHappy(theNumber.toString())) {
            sj.add("happy");
        } else {
            sj.add("sad");
        }

        System.out.println(sj);
    }

    public static boolean checkTwoNumbers(String[] array) {

        String firstNumber = array[0];
        String secondNumber = array[1];

        BigInteger theFirstNumber = new BigInteger(firstNumber);
        // if first number is > 0
        if (Utility.isNotNatural(theFirstNumber)) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        }

        BigInteger theSecondNumber = new BigInteger(secondNumber);
        // if second number is > 0
        if (Utility.isNotNatural(theSecondNumber)) {
            System.out.println("The second parameter should be a natural number or zero.");
            return false;
        }

        return true;
    }

    public static void iterateNumbers(String[] array) {
        String firstNumber = array[0];
        String secondNumber = array[1];
        BigInteger theFirstNumber = new BigInteger(firstNumber);
        int times = Integer.parseInt(secondNumber);

        for (int j = 0; j < times; j++) {
            shortList(theFirstNumber);
            theFirstNumber = theFirstNumber.add(BigInteger.ONE);
        }
    }

    static boolean checkProperties(String[] array) {
        // check that all the properties asked are correct
        String[] properties = Arrays.copyOfRange(array, 2, array.length);

        String[] arrayOfProperties = new String[]{"even", "-even", "odd", "-odd", "buzz", "-buzz", "duck", "-duck", "palindromic", "-palindromic", "gapful", "-gapful", "spy", "-spy", "square", "-square", "sunny", "-sunny", "jumping", "-jumping", "happy", "-happy", "sad", "-sad"};
        StringJoiner wrongProperties = new StringJoiner(", ");

        boolean wrongProperty;
        int wrongPropertyCounter = 0;

        // check if the property requested is in the list of the properties.
        for (String property : properties) {
            wrongProperty = true;
            for (String arrayOfProperty : arrayOfProperties) {
                if (property.equalsIgnoreCase(arrayOfProperty)) {
                    wrongProperty = false;
                    break;
                }
            }
            if (wrongProperty) {
                wrongProperties.add(property);
                wrongPropertyCounter++;
            }
        }

        switch (wrongPropertyCounter) {
            case 0:
                break;
            case 1:
                System.out.format("%nThe property [%s] is wrong.%n", wrongProperties.toString().toUpperCase(Locale.ROOT));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                return false;
            default:
                System.out.format("%nThe properties [%s] are wrong.%n", wrongProperties.toString().toUpperCase(Locale.ROOT));
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                return false;
        }

        // check for mutual exclusive properties
        for (String theProperty : properties) {
            for (String property : properties) {
                if (theProperty.equalsIgnoreCase("-" + property)) {
                    System.out.format("The request contains mutually exclusive properties: [%s, %s]%n", theProperty, property);
                    System.out.println("There are no numbers with these properties.");
                    return false;
                }
            }
        }

        // if properties are ok, check for incompatible items between them:
        //Even and Odd, Duck and Spy, Sunny and Square
        int even = 0;
        int _even = 0;
        int odd = 0;
        int _odd = 0;
        int duck = 0;
        int _duck = 0;
        int spy = 0;
        int _spy = 0;
        int sunny = 0;
        int _sunny = 0;
        int square = 0;
        int _square = 0;
        int sad = 0;
        int _sad = 0;
        int happy = 0;
        int _happy = 0;

        for (String property : properties) {
            switch (property.toLowerCase(Locale.ROOT)) {
                case "even":
                    even++;
                    break;
                case "-even":
                    _even++;
                    break;
                case "odd":
                    odd++;
                    break;
                case "-odd":
                    _odd++;
                    break;
                case "duck":
                    duck++;
                    break;
                case "-duck":
                    _duck++;
                    break;
                case "spy":
                    spy++;
                    break;
                case "-spy":
                    _spy++;
                    break;
                case "sunny":
                    sunny++;
                    break;
                case "-sunny":
                    _sunny++;
                    break;
                case "square":
                    square++;
                    break;
                case "-square":
                    _square++;
                    break;
                case "sad":
                    sad++;
                    break;
                case "-sad":
                    _sad++;
                    break;
                case "happy":
                    happy++;
                    break;
                case "-happy":
                    _happy++;
                    break;
            }
        }
        // check if parameters are incompatible
        if (even == odd && even > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [EVEN, ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (_even == _odd && _even > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [-EVEN, -ODD]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (duck == spy && duck > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [DUCK, SPY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (_duck == _spy && _duck > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [-DUCK, -SPY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (sunny == square && sunny > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [SUNNY, SQUARE]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (_sunny == _square && _sunny > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [-SUNNY, -SQUARE]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (sad == happy && sad > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [SAD, HAPPY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        } else if (_sad == _happy && _sad > 0) {
            System.out.println("\nThe request contains mutually exclusive properties: [-SAD, -HAPPY]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }

        return true;
    }

    static boolean isBuzz(BigInteger number) {

        BigInteger seven = new BigInteger("7");
        boolean isDivisibleBy7;
        boolean endsIn7;
        isDivisibleBy7 = BigInteger.ZERO.compareTo(number.remainder(seven)) == 0;
        endsIn7 = seven.compareTo(number.remainder(BigInteger.TEN)) == 0;

        return isDivisibleBy7 || endsIn7;
    }

    static boolean isEven(BigInteger number) {
        return BigInteger.ZERO.compareTo(number.remainder(BigInteger.TWO)) == 0;
    }

    static boolean isNotNatural(BigInteger number) {
        return number.compareTo(BigInteger.ZERO) <= 0;
    }

    static boolean isSpy(String number) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;

        // sum the digits
        for (int i = 0; i < number.length(); i++) {
            sum = sum.add(new BigInteger(String.valueOf(number.charAt(i))));
        }

        // multiply the digits
        for (int i = 0; i < number.length(); i++) {
            product = product.multiply(new BigInteger(String.valueOf(number.charAt(i))));
        }

        return sum.compareTo(product) == 0;
    }

    static boolean isDuck(BigInteger number) {
        //While taking standard input from the console the zero at charAt(0) is removed.
        // Suppose 012 if you print this it's 12. Hope you got it.
        return number.toString().contains("0");
    }

    static boolean isPalindromic(String number) {
        if (number.length() == 1) return true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int start;
        int end;
        start = 0;
        end = number.length() / 2;
        sb1.append(number, start, end);
        start = number.length() % 2 == 0 ? number.length() / 2 : number.length() / 2 + 1;
        end = number.length();
        sb2.append(number, start, end);
        sb2.reverse();
        return sb1.toString().equals(sb2.toString());
    }

    static boolean isGapful(String number) {
        if (number.length() < 3) return false;
        BigInteger gapNumber = new BigInteger(String.valueOf(number.charAt(0)) + number.charAt(number.length() - 1));
        BigInteger intNumber = new BigInteger(number);

        return BigInteger.ZERO.compareTo(intNumber.remainder(gapNumber)) == 0;
    }

    static boolean isNumeric(String number) {
        if (number == null || number.length() == 0) return false;
        return number.chars().allMatch(Character::isDigit);
    }

    static boolean isNullString(String number) {
        return (number == null || number.isEmpty());
    }

    static boolean isSquare(BigInteger number) {
        BigInteger[] array = number.sqrtAndRemainder();
        return BigInteger.ZERO.compareTo(array[1]) == 0;
    }

    static boolean isSunny(BigInteger number) {
        number = number.add(BigInteger.ONE);
        BigInteger[] array = number.sqrtAndRemainder();
        return BigInteger.ZERO.compareTo(array[1]) == 0;
    }

    static boolean isJumping(String number) {
        if (number.length() == 1) return true;
        int adjacentNumber;
        int difference;
        boolean adjacent = true;
        adjacentNumber = Integer.parseInt(String.valueOf(number.charAt(0)));
        for (int i = 1; i < number.length(); i++) {
            int currentNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            difference = adjacentNumber - currentNumber;
            if (Math.abs(difference) == 1) {
                adjacentNumber = currentNumber;
            } else {
                adjacent = false;
                break;
            }
        }
        return adjacent;
    }

    static boolean isHappy(String number) {
        int value = 0;
        for (int i = 0; i < number.length(); i++) {
            double tempValue = Double.parseDouble(String.valueOf(number.charAt(i)));
            value += (int) Math.pow(tempValue, 2);
        }
        if (value < 10) {
            return value == 1;
        } else {
            return isHappy(String.valueOf(value));
        }
    }
}