package AnotherContest;

import java.util.Scanner;

public class LonelyUsers {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(Math.max(scanner.nextLong()-1, 0));
        }
    }
}
