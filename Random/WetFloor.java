package Random;

import java.util.Scanner;

public class WetFloor {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[][] wet = new boolean[n][m];
        boolean[][] cone = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0;j < m; j++) {
                if (input.charAt(j) == 'W') {
                    wet[i][j] = true;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (k == 0 || l == 0) {
                                if (k + i >= 0 && k + i < n && l + j >= 0 && l + j < m) {
                                    cone[k + i][j + l] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cone[i][j] && !wet[i][j]) {
                    System.out.print("C");
                } else if (wet[i][j]) {
                    System.out.print("W");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
