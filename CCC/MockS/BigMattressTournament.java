package CCC.MockS;

import java.util.Scanner;

public class BigMattressTournament {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if ((a + (b * 2) + (c * 3)) % 2 == 1) {
                System.out.println("NO");
                continue;
            }
            if (a < c) {
                System.out.println("NO"); continue;
            }
            if (b % 2 == 1 && (a) < 1) {
                System.out.println("NO"); continue;
            }
            System.out.println("YES");
        }
    }
}
