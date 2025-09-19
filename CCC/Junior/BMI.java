package CCC.Junior;

import java.util.Scanner;

public class BMI {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        double height = scanner.nextDouble();
        double bmi = weight / (height * height);
        if (bmi > 25) {
            System.out.println("Overweight");
        } else if (bmi < 18.5) {
            System.out.println("Underweight");
        } else {
            System.out.println("Normal weight");
        }
    }
}
