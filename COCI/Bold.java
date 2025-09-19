package COCI;

import java.util.Scanner;

public class Bold {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        boolean[][] ar = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '#') {
                    ar[i][j] = true;
                    ar[i][j + 1] = true;
                    ar[i + 1][j] = true;
                    ar[i + 1][j + 1] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j]) System.out.print("#");
                else System.out.print(".");
            }
            System.out.println();
        }
    }
}
