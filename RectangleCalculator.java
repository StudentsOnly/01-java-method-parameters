import java.util.Scanner;

public class RectangleCalculator{
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle: ");
        int length = s.nextInt();
        System.out.println("Enter the width of the rectangle: ");
        int width = s.nextInt();

        System.out.printf("Area: %d\nPerimeter %d",calculateArea(length, width), calculatePerimeter(length, width));
    }

    static int calculateArea(int length, int width){
        return length * width;
    }

    static int calculatePerimeter(int length, int width){
        return (length + width) * 2;
    }
}
