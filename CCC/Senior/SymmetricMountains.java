package CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SymmetricMountains {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = Integer.parseInt(next());
        int[] height = new int[n];
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(next());
        }
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < n && left + i - 1 < n; left++) {
                int right = left + i - 1;
                memo[i][left] = memo[i - 2][left + 1] + Math.abs(height[right] - height[left]);
            }
        }
        int count = 0;
        System.out.print(0 + " ");
        for (int[] rows : memo) {
            if (count < 2) {
                count++;
                continue;
            }
            Arrays.sort(rows, 0, n - count++ + 1);
            System.out.print(rows[0] + " ");
        }
        System.out.println();
    }
    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}