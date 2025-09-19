package Random;

import java.util.Scanner;

public class Alphabet {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[][] memo = new int[input.length + 1][27];
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= 26; j++) {
                if (input[i - 1] == alphabet[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                }
                memo[i][j] = Math.max(Math.max(memo[i][j], memo[i - 1][j]), memo[i][j - 1]);
            }
        }
        System.out.println(26 - memo[input.length][26]);
    }
}
