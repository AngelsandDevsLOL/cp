package CCC.MockS;

import java.util.Scanner;

public class OwenTheToucan {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        for (int i = 0; i < n - k; i++) {
            System.out.print((i + 2) + " ");
        }
        System.out.print(1 + " ");
        for (int i = n - k + 2; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
