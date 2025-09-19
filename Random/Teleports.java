package Random;

import java.util.*;

public class Teleports {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] ar = new int[m + n + 1];
        ArrayList<Integer>[] rev = new ArrayList[m + n + 1];
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 1; i < m + n + 1; i++) {
            rev[i] = new ArrayList<>();
            hSet.add(i);
        }
        for (int i = 1; i <= m; i++) {
            int next = sc.nextInt();
            ar[i] = (next + m);
            rev[next + m].add(i);
        }
        for (int i = 1; i <= n; i++) {
            int next = sc.nextInt();
            ar[i + m] = (next);
            rev[next].add(i + m);
        }
        int[] ans = new int[m + n + 1];
        Queue<Integer> q = new LinkedList<>(); // put receiving in
        for (int i = 1; i < m + n + 1; i++) {
            if (rev[i].isEmpty()) {
                ans[i] = 2;
                if (ans[ar[i]] == 0) {
                    q.add(ar[i]);
                    ans[ar[i]] = 1;
                    hSet.remove(i);
                    hSet.remove(ar[i]);
                } else {
                    hSet.remove(i);
                }
            }
        }
        while (!hSet.isEmpty()) {
            while (!q.isEmpty()) {
                int x = q.poll(); // always receiving
                for (int next : rev[x]) {
                    if (ans[next] == 0) {
                        ans[next] = 2;
                        hSet.remove(next);
                       // if (ans[ar[next]] == )
                    }
                }
                if (rev[ar[x]].size() == 1) {
                    ans[ar[x]] = 2;
                    hSet.remove(ar[x]);
                    if (ans[ar[ar[x]]] == 0) {

                    }
                }
            }
            for (int x : hSet) {
                q.add(x);
                ans[x] = 1;
                break;
            }
        }
    }
}
