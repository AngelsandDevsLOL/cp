package Random;

import java.util.Scanner;

public class TheMostImportantSkillinBiology {
    // useless
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][2];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            ar[i][0] = sc.nextInt(); ar[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            sum1 += ar[i][0] * ar[i + 1][1];
            sum2 += ar[i][1] * ar[i + 1][0];
        }
        sum1 += ar[n - 1][0] * ar[0][1];
        sum2 += ar[n - 1][1] * ar[0][0];
        System.out.println((int)Math.ceil(Math.abs(sum1 - sum2) / 2.0));
    }
}
