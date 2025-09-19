package COCI;

import java.util.Scanner;

public class Okvir {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int u = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt(), d = sc.nextInt();
        char[][] ar = new char[m + u + d][n + l + r];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                ar[i][j] = ((i + j) % 2 == 0) ? '#' : '.';
            }
        }
        sc.nextLine();
        for (int i = u; i < m + u; i++) {
            String input = sc.nextLine();
            for (int j = l; j < n + l; j++) {
                ar[i][j] = input.charAt(j - l);
            }
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }
    }
}
