package OCC;

import java.util.Scanner;
import java.util.TreeMap;

public class PlayingWithNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] ar = new int[n + 2];
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int cur = 0;
        ar[0] = Integer.MIN_VALUE;
        tMap.put(0, 0);
        for (int i = 1; i <= n; i++) {
            ar[i] = sc.nextInt();
            if (ar[i] >= ar[i - 1]) {
                cur++;
            } else {
                tMap.put(i - cur + 1, cur);
                cur = 0;
            }
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            // careful of endpoints things
            if (tMap.containsKey(a)) { // beginning of a thing
                // 1 2 3 1 5 6 =>> 1 2 3 4 5 6 (merge) 1
                // 1 2 3 1 5 6 => 1 2 3 2 5 6 (no change) 2
                // 1 2 3 1 1 2 => 1 2 3 2 1 2 split !
                // 1 2 3 1 1 2 => 1 2 3 4 1 2 (add to prev, reduce 1) 3
                if (b >= ar[a - 1]) { // 1 and 3
                    if (b <= ar[a + 1]) { // merge !
                        int size = tMap.get(a);
                        tMap.remove(a);
                        int prev = tMap.lowerKey(a);
                        tMap.put(prev, tMap.get(prev) + size);
                    } else { // add to prev, reduce 1 (3)
                        int size = tMap.get(a);
                        tMap.remove(a);
                        int prev = tMap.lowerKey(a);
                        tMap.put(a + 1, size - 1);
                        tMap.put(prev, tMap.get(prev) + 1);
                    }
                } else {
                    if (b <= ar[a + 1]) {
                        continue; // no change ??
                    } else {
                        int size = tMap.get(a);
                        tMap.put(a, 1);
                        tMap.put(a + 1, size - 1);
                    }
                }
            } else { // in the middle
                if (b <= ar[a + 1] && ar[a - 1] <= b) {
                    // no change
                } else if (b <= ar[a + 1]) { // ar[a - 1] > b

                }
            }
        }
    }
}
