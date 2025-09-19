package CCC.Junior;

import java.util.Scanner;

public class DogTreats {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();
        if (s + 2 * m + 3 * l >= 10) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }
}
