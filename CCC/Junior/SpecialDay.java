package CCC.Junior;

import java.util.Scanner;

public class SpecialDay {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        if (month == 2 && day == 18) {
            System.out.println("Special");
        } else if (month == 2 && day > 18) {
            System.out.println("After");
        } else if (month <= 2) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }
    }
}
