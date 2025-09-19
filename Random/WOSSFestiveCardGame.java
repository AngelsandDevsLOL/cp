package Random;

import java.util.Scanner;

public class WOSSFestiveCardGame {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = n; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println("1 2");
        } else if (n == 3) {
            System.out.println("1 3 2");
        } else if (n == 4) {
            System.out.println("1 3 4 2");
        } else {
            System.out.print("1 3 4 ");
            for (int i = 5; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println(2);
        }
    }
}
