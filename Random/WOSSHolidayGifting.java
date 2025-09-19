package Random;

import java.util.Scanner;

public class WOSSHolidayGifting {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = scanner.nextInt();
        count += scanner.nextInt() * 4;
        count += scanner.nextInt() * 7;
        if (count > n) {
            System.out.println("You cannot afford them all.");
        } else {
            System.out.println("Time to go shopping!");
        }
    }
}
