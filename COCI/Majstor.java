package COCI;

import java.util.Scanner;

public class Majstor {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int[][] ar = new int[r][3];
        sc.nextLine();
        String input = sc.nextLine();
        int f = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < f; i++) {
            String x = sc.nextLine();
            for (int j = 0; j < r; j++) {
                if (x.charAt(j) == 'R') {
                    ar[j][0]++;
                } else if (x.charAt(j) == 'P') {
                    ar[j][1]++;
                } else {
                    ar[j][2]++;
                }
            }
        }
        int count = 0;
        int best = 0;
        for (int i = 0; i < r; i++) {
            char x = input.charAt(i);
            int a = 0;
            int b = 0;
            int c = 0;
            a = ar[i][2] + 2 * (ar[i][1]);
            b = ar[i][1] + 2 * (ar[i][0]);
            c = ar[i][0] + 2 * (ar[i][2]);
            if (x == 'S') {
                count += a;
            } else if (x == 'P') {
                count += b;
            } else {
                count += c;
            }
            best += Math.max(a, Math.max(b, c));
        }
        System.out.println(count);
        System.out.println(best);
    }
}
