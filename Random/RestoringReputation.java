package Random;

import java.util.Arrays;
import java.util.Scanner;

public class RestoringReputation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(), i = sc.nextInt(), r = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[][] ar = new int[input[0].length() + 1][input[1].length() + 1];
        for (int j = 1; j <= input[1].length(); j++) {
            ar[0][j] = (ar[0][j - 1] + i);
        }
        for (int j = 1; j <= input[0].length(); j++) {
            ar[j][0] = (ar[j - 1][0] + d);
        }
        for (int j = 1; j <= input[0].length(); j++) {
            for (int k = 1; k <= input[1].length(); k++) {
                if (input[0].charAt(j - 1) == input[1].charAt(k - 1)) ar[j][k] = ar[j - 1][k - 1];
                else {
                    ar[j][k] = Math.min(ar[j - 1][k] + d, Math.min(ar[j][k - 1] + i, Math.min(ar[j - 1][k - 1] + i + r, ar[j - 1][k - 1] + r)));
                }
            }
        }
        System.out.println(ar[input[0].length()][input[1].length()]);
    }
}
