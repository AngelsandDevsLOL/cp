package CCC.Senior;

import java.util.Scanner;

public class SwappingSeats {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int n = in.length();
        int[][] ar = new int[3][n * 2 + 1];
        for (int i = 1; i <= in.length(); i++) {
            ar[in.charAt(i - 1) - 'A'][i]++;
            ar[in.charAt(i - 1) - 'A'][i + n]++;
            ar[0][i] += ar[0][i - 1];
            ar[1][i] += ar[1][i - 1];
            ar[2][i] += ar[2][i - 1];
        }
        for (int i = n + 1; i <= 2*n; i++) {
            ar[0][i] += ar[0][i - 1];
            ar[1][i] += ar[1][i - 1];
            ar[2][i] += ar[2][i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int endA = i + ar[0][n] - 1;
            int numA = ar[0][endA] - ar[0][i - 1];
            int numNotA = ar[0][n] - numA;
            int numBinA = ar[1][endA] - ar[1][i - 1];
            int endB = i + ar[0][n] + ar[1][n] - 1;
            int numB = ar[1][endB] - ar[1][endA];
            int numNotB = ar[1][n] - numB;
            int numAinB = ar[0][endB] - ar[0][endA];
            min = Math.min(min, numNotA + numNotB - Math.min(numBinA, numAinB));
        }
        System.out.println(min);
    }
}
