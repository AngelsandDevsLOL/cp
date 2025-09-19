package CCC.Senior;

import java.util.*;

public class GoodSamples {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(); long k = sc.nextLong();
        k = k - n;
        int[] ans = new int[n];
        ans[0] = 1;
        int[] prev = new int[m + 1];
        Arrays.fill(prev, -1);
        prev[1] = 0;
        ArrayList<Integer> q = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            q.add(i + 1);
        }
        q.add(1);
        int num = 0;
        for (int i = 1; i < n; i++) {
            if (k < 0) {
                break;
            }
            if ((i - num) <= k) { // give distinct #
                ans[i] = q.remove(0);
                num = Math.max(num, prev[ans[i]] + 1);
                k -= (i - num);
                prev[ans[i]] = i;
                q.add(ans[i]);
            } else {
                ans[i] = q.remove(q.size() - (int) k - 1);
                k -= i - Math.max(num, prev[ans[i]] + 1);
                prev[ans[i]] = i;
                q.add(ans[i]);
                num = i;
            }
        }
        if (k == 0) {
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        } else System.out.println(-1);
    }
}
