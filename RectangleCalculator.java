import java.util.NoSuchElementException;
import java.util.Scanner;

public class RectangleCalculator {
    public static void main(String[] args) {
        int width, length, area, perimeter;

        while (true) {
            do {
                System.out.println("Enter the length of the rectangle: ");
                String input = handleStringInput();
                length = handleIntParsing(input);
            } while (length <= 0);

            do {
                System.out.println("Enter the width of the rectangle: ");
                String input = handleStringInput();
                width = handleIntParsing(input);
            } while (width <= 0);

            try {
                area = calculateArea(length, width);
                perimeter = calculatePerimeter(length, width);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

    }

    private static int calculateArea(int length, int width) throws IllegalArgumentException {
        checkPositiveness(length);
        checkPositiveness(width);
        return length * width;
    }

    private static int calculatePerimeter(int length, int width) throws IllegalArgumentException {
        checkPositiveness(length);
        checkPositiveness(width);
        return (length + width) * 2;
    }

    private static String handleStringInput() {
        try (Scanner s = new Scanner(System.in)) {
            return s.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error in scanner");
            return null;
        }
    }

    private static int handleIntParsing(String lineToParse) {
        int number;
        try {
            number = Integer.parseInt(lineToParse);
            checkPositiveness(number);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Can't parse this line");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static void checkPositiveness(int number) throws IllegalArgumentException {
        if (number <= 0) throw new IllegalArgumentException("Number must be positive");
    }

}
