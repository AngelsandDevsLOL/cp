package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class Golf {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] memo = new int[x+1];
        Arrays.fill(memo, (int) 1e9); memo[0] = 0;
        for (int i = 0; i < y; i++) {
            int input = sc.nextInt();
            for (int j = input; j < x + 1; j++) {
                memo[j] = Math.min(memo[j], memo[j - input] + 1);
            }
        }
        System.out.println(memo[x] >= 1e9 ? "Roberta acknowledges defeat." : "Roberta wins in " + memo[x] + " strokes.");
    }
}