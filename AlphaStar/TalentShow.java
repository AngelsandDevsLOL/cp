package AlphaStar;

import java.util.Scanner;

public class TalentShow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] freqLeft = new int[m + 1];
        int[] freqRight = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt(), x2 = sc.nextInt();
            freqLeft[x1]++; freqRight[x2]++;
        }
        int[][] ar = new int[2 * m + 2][2];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                ar[i + j][0] += freqLeft[i] * freqLeft[j];
                ar[i + j][1] += freqRight[i] * freqRight[j];
            }
        }
        for (int i = 1; i < 2 * m + 2; i++) {
            ar[i][0] += ar[i - 1][0];
            ar[2 * m + 1 - i][1] += ar[2 * m - i + 2][1];
        }
        for (int i = 0; i <= 2 * m; i++) {
            System.out.println(ar[i][0] * ar[i][1]);
        }
    }
}
