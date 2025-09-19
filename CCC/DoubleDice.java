package CCC;

import java.util.Scanner;

public class DoubleDice {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dPoints = 100;
        int aPoints = 100;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int d = scanner.nextInt();
            if (a > d) {
                dPoints = dPoints - a;
            } else if (a < d) {
                aPoints = aPoints-d;
            }
        }
        System.out.println(aPoints);
        System.out.println(dPoints);
    }
}
