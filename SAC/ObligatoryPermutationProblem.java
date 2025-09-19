package SAC;

import java.util.*;

public class ObligatoryPermutationProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        boolean[] vis = new boolean[n + 1];
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            List<Integer> cycle = new ArrayList<>();
            for (int j = i; !vis[j]; j = p[j]) {
                cycle.add(j); vis[j] = true;
            }
            int rem = (int) (k % cycle.size());
            for (int j = 0; j < cycle.size(); j++) {
                int cur = cycle.get(j);
                int nxt = cycle.get((j + rem) % cycle.size());
                ans[nxt] = p[cur];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + (i == n ? "\n" : " "));
        }
    }
}