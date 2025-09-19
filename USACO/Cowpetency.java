package USACO;

import java.util.*;

public class Cowpetency {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), q = sc.nextInt(), c = sc.nextInt();
            int[] cows = new int[n];
            for (int j = 0; j < n; j++) {
                cows[j] = sc.nextInt();
            }
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            HashMap<Integer, Integer> hMap = new HashMap<>();
            for (int j = 0; j < q; j++) {
                int x = sc.nextInt(), y = sc.nextInt();
                if (!hMap.containsKey(y) || hMap.get(y) < x) {
                    hMap.put(y, x);
                }
            }
            for (int x : hMap.keySet()) {
                tMap.put(hMap.get(x), x);
            }
            if (cows[0] == 0) cows[0] = 1;
            int cur = 1;
            int max = cows[0];
            boolean possible = true;
            for (int x : tMap.keySet()) {
                for (; cur < x;) {
                    cur++;
                    max = Math.max(max, cows[cur - 1]);
                }
                int next = tMap.get(x) - 1;
                if (cows[next] == 0) {
                    cows[next] = max + 1;
                } else if (cows[next] > max) {

                } else {
                    possible = false;
                    break;
                }
                if (max > c) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                for (int j = 0; j < n - 1; j++) {
                    if (cows[j] == 0) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(cows[j] + " ");
                    }
                }
                if (cows[n - 1] == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(cows[n - 1]);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
