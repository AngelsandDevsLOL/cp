package CCC;

import java.util.Scanner;

public class DogTreats {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int line1 = scanner.nextInt();
        int line2 = scanner.nextInt();
        int line3 = scanner.nextInt();
        if (line1 + (2 * line2) + (3 * line3) >= 10) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}
