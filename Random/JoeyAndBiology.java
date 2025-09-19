package Random;

import java.util.Scanner;

public class JoeyAndBiology {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        int[][] ar = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            if (i - 3 < 0) {
                ar[0][i] = ar[0][0] + 1;
            } else {
                ar[0][i] = ar[0][i - 3] + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i - 3 < 0) {
                ar[i][0] = ar[0][0] + 1;
            } else {
                ar[i][0] = ar[i - 3][0] + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    ar[i][j] = (ar[i - 1][j - 1]);
                    int min = Math.max(0, i - 3);
                    for (int k = min; k < i; k++) {
                        ar[i][j] = Math.min(ar[k][j] + 1, ar[i][j]);
                    }
                    int max = Math.max(0, j - 3);
                    for (int k = max; k < j; k++) {
                        ar[i][j] = Math.min(ar[i][k] + 1, ar[i][j]);
                    }
                } else {
                    ar[i][j] = (ar[i - 1][j - 1] + 1);
                    int min = Math.max(0, i - 3);
                    for (int k = min; k < i; k++) {
                        ar[i][j] = Math.min(ar[k][j] + 1, ar[i][j]);
                    }
                    int max = Math.max(0, j - 3);
                    for (int k = max; k < j; k++) {
                        ar[i][j] = Math.min(ar[i][k] + 1, ar[i][j]);
                    }
                }
            }
        }
        System.out.println(ar[n][m]);
    }
}
