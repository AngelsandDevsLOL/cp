package COCI;

import java.util.Scanner;

public class Prozor {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), s = sc.nextInt(), k = sc.nextInt();
        int[][] psa = new int[r][s];
        boolean[][] mosq = new boolean[r][s];
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            char[] input = sc.nextLine().toCharArray();
            for (int j = 0; j < s; j++) {
                if (input[j] == '*') {
                    mosq[i][j] = true;
                    psa[i][j]++;
                }
            }
        }
        for (int i = 1; i < r; i++) {
            psa[i][0] += psa[i - 1][0];
        }
        for (int i = 1; i < s; i++) {
            psa[0][i] += psa[0][i - 1];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < s; j++) {
                psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
            }
        }
        int max = 0;
        int x = 0, y = 0;
        for (int i = 0; i <= r - k; i++) {
            for (int j = 0; j <= s - k; j++) {
                int val = psa[i + k - 2][j + k - 2] - psa[i + k - 2][j] - psa[i][j + k - 2] + psa[i][j];
                if (val > max) {
                    max = val;
                    x = i; y = j;
                }
            }
        }
        System.out.println(max);
        psa[x][y] = -1;
        psa[x][y + k - 1] = -1;
        psa[x + k - 1][y] = -1;
        psa[x + k - 1][y + k - 1] = -1;
        for (int i = 1; i < k - 1; i++) {
            psa[x][y + i] = -2;
            psa[x + k - 1][y + i] = -2;
            psa[x + i][y] = -3;
            psa[x + i][y + k - 1] = -3;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if (psa[i][j] == -1) System.out.print("+");
                else if (psa[i][j] == -2) System.out.print("-");
                else if (psa[i][j] == -3) System.out.print("|");
                else if (mosq[i][j]) {
                    System.out.print("*");
                } else System.out.print(".");
            }
            System.out.println();
        }
    }
}
