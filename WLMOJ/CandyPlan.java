package WLMOJ;

import java.util.Scanner;

public class CandyPlan {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt() / 90;
        sc.nextLine();
        char[][] ar = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                ar[i][j] = input[j].charAt(0);
            }
        }
        ar = rotate(ar, new char[n][n], k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static char[][] rotate (char[][] ar, char[][] newAr, int num) {
        if (num == 0) return ar;
        int n = ar.length;
        int x = (int)Math.ceil(n/ 2.0);
        for (int i = 0; i < x; i++) {
            for (int j = i; j < n - i; j++) {
                newAr[j][n - i - 1] = ar[i][j];
                newAr[n - i - 1][n - j - 1] = ar[j][n - i - 1];
                newAr[n - j - 1][i] = ar[n - i - 1][n - j - 1];
                newAr[i][j] = ar[n - j - 1][i];
            }
        }
        return rotate(newAr, new char[n][n], --num);
    }
}
