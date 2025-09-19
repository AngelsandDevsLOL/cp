package VM7WC;

import java.util.Scanner;

public class RestoringReputation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(), i = sc.nextInt(),r = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        String prev = input[0];
        String next = input[1];
        int[][] ans = new int[prev.length() + 1][next.length() + 1];
        for (int j = 1; j <= prev.length(); j++) {
            ans[j][0] += ans[j - 1][0] + d;
        }
        for (int j = 1; j <= next.length(); j++) {
            ans[0][j] += ans[0][j - 1] + i;
        }
        r = Math.min(r, d + i);
        for (int j = 1; j <= prev.length(); j++) {
            for (int k = 1; k <= next.length(); k++) {
                if (prev.charAt(j - 1) == next.charAt(k - 1)) {
                    ans[j][k] = ans[j - 1][k - 1]; continue;
                }
                ans[j][k] = Math.min(ans[j - 1][k - 1] + r, Math.min(ans[j - 1][k] + d, ans[j][k - 1] + i));
            }
        }
        System.out.println(ans[prev.length()][next.length()]);
    }
}
