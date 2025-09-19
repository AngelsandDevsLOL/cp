package NoContest;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class ADigitProblem {
    static int mask2;
    static String k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            mask2 |= 1 << nums[i];
        }
        sc.nextLine();
        k = sc.nextLine();
        int n = k.length();

        long[][][] memo = new long[n][2][(int)Math.pow(2, 11)-1];
        for (long[][] arr : memo) {
            for (long[] subArr : arr) {
                Arrays.fill(subArr, -1);
            }
        }
        long number = recursion(0, true, 0, memo);
        if (nums[0] == 0 && nums.length == 1L) number++;
        System.out.println(number);
    }

    public static long recursion(int pos, boolean limit, int mask, long[][][] memo) {
        if (pos == k.length()) {
            return ((mask & mask2) == mask2 ? 1 : 0);
        }

        if (memo[pos][limit ? 1 : 0][mask] != -1) {
            return memo[pos][limit ? 1 : 0][mask];
        }

        int maxDigit = (limit ? k.charAt(pos) - '0' : 9);
        int count = 0;

        for (int i = 0; i <= maxDigit; i++) {
            int newMask = mask;
            if (newMask != 0 || i != 0) newMask |= (1 << i);
            count += recursion(pos + 1, limit && (i == maxDigit), newMask, memo);
            count %= 1000000007;
        }

        memo[pos][limit ? 1 : 0][mask] = count;
        return count;
    }
}
