package Random;

import java.util.Scanner;

public class UACCPuzzlingParks {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            if (n == 2) System.out.println(1);
            else if (n % 4 == 0) System.out.println(n / 2 * 3 - 1);
            else System.out.println(n / 2 * 3 - 2);
        } else {
            if (n == 3) System.out.println(4);
            else if ((n - 1) % 4 == 0) System.out.println((n - 1) / 2 * 3);
            else System.out.println((n - 1) / 2 * 3 + 1);
        }
    }
}
