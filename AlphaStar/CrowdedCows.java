package AlphaStar;

import java.util.*;

public class CrowdedCows {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), h = sc.nextInt();
            ar[i][1] = x; ar[i][0] = h;
        }
        int ans = 0;
        Arrays.sort(ar, (x, y) -> Integer.compare(x[1], y[1]));
        TreeMap<Integer, Integer> after = new TreeMap<>();
        TreeMap<Integer, Integer> before = new TreeMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && ar[i - 1][1] + d >= ar[i][1]) {
                int h = ar[i - 1][0];
                if (before.containsKey(h)) before.put(ar[i][0], before.get(h) + 1);
                else before.put(h, 1);
                h = ar[i][0];
                if (after.get(h) == 1) after.remove(h);
                else after.put(h, after.get(h) - 1);
            }
            int pos = ar[i][1];
            int h = ar[i][0];
            while (right < n - 1 && ar[right + 1][1] <= pos + d) { // check right to see if expand
                right++;
                if (after.containsKey(ar[right][0])) {
                    after.put(ar[right][0], after.get(ar[right][0]) + 1);
                } else {
                    after.put(ar[right][0], 1);
                }
            }
            if (right >= n - 1 && ar[right][1] > pos + d) break;
            while (ar[left][1] < pos - d && !before.isEmpty()) { // check left to see if decrease
                if (before.get(ar[left][0]) == 1) {
                    before.remove(ar[left][0]);
                } else {
                    before.put(ar[left][0], before.get(ar[left][0]) - 1);
                }
                left++;
            }
            if (after.floorKey(Integer.MAX_VALUE) != null && after.floorKey(Integer.MAX_VALUE) >= 2 * h && before.floorKey(Integer.MAX_VALUE) != null && before.floorKey(Integer.MAX_VALUE) >= 2 * h) ans++;
        }
        System.out.println(ans);
    }
    public static class Pair implements Comparable<Pair> {
        int h;
        int d;
        public Pair (int hh, int dd) {
            d = dd; h = hh;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(d, o.d);
        }
    }
}
