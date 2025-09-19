package Random;

import java.util.Arrays;
import java.util.Scanner;

public class JaydenEatsChocolate {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = 3;
        int[] memo = new int[x+1];
        Arrays.fill(memo, -Integer.MAX_VALUE); memo[0] = 0;
        for (int i = 0; i < y; i++) {
            int input = sc.nextInt();
            for (int j = input; j < x + 1; j++) {
                memo[j] = Math.max(memo[j], memo[j - input] + 1);
            }
        }
        System.out.println(memo[x]);
    }
}
