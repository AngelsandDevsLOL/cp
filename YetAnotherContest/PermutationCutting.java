package YetAnotherContest;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationCutting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt() - 1;
        }
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[sc.nextInt() - 1] = i;
        }
        int ans = 1;
        int cur = t[s[0]];
        for (int i = 1; i < n; i++) {
            if (t[s[i]] == cur + 1) {
                cur++;
            } else {
                ans++;
                cur = t[s[i]];
            }
        }
        System.out.println(ans);
    }
}
