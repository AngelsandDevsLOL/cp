package CCC.Senior;

import java.util.Scanner;

public class Censor {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] ar = scanner.nextLine().split(" ");
            for (int j = 0; j < ar.length; j++) {
                if (ar[j].length() == 4) {
                    ar[j] = "****";
                }
                System.out.print(ar[j] + " ");
            }
            System.out.println();
        }
    }
}
