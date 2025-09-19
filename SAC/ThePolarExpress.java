package SAC;

import java.util.Scanner;

public class ThePolarExpress {
    static int[][] dp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), r = sc.nextInt();
        int length = String.valueOf(r).length();
        dp = new int[(int) (Math.ceil(r / 9.0) + 10)][length]; // value, sum
        // base case [0, 0] = 1
        // 0 to 2  = 3 (0, 1, 2)
        // [1, 1] = 1
        // [2, 2] = 2
        // [3, 3] = 1
        // [4, 4] = 1
        // []
        // []
        // [99, 18] = 1
        // [20, 10] = [19, 9] + [18, 8] + [17, 7] + [16, 6] + [15, 5] + [14, 4] + [13, 3] + [12, 2] + [11, 1]
        // [19, 9] = 9, 18

    }
}
