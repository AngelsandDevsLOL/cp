package CCC.MockJ;

import java.util.Scanner;

public class SnowboardingChampions {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int t = scanner.nextInt();
        int timea = n;
        int timet = n;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (!(x < a)) {
                timea++;
            }
            if (!(y < t)) {
                timet++;
            }
        }
        if (timea == timet) {
            System.out.println("Tie!");
        } else if (timea > timet) {
            System.out.println("Tommy wins!");
        } else {
            System.out.println("Andrew wins!");
        }
    }
}
