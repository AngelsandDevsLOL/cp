package DMOPC;

import java.util.*;

public class ColourScheme {
    public static Scanner sc;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1; // distinct thingamathing
        int[] ans = new int[n + 1];
        int previous = 1;
        TreeMap<Integer, Integer> prev = new TreeMap();
        TreeSet<Integer> index = new TreeSet<>();
        ans[1] = 1;
        index.add(1);
        prev.put(1, 1);
        for (int i = 2; i <= n; i++) {
            int x = check(1, i);
            if (x > previous) {
                ans[i] = ++count;
                index.add(i);
                prev.put(count, i);
                previous = x;
                continue;
            }
            previous = x;
            int num = bsearch(1, index.size(), i, index);
            ans[i] = ans[num];
            index.remove(prev.get(ans[num])); // remove old ind
            prev.put(ans[num], i); // update prev
            index.add(i); // add new ind
        }
        System.out.print("! ");
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    public static int bsearch (int low, int high, int ind, TreeSet<Integer> tSet) {
        Object[] ar = tSet.toArray();
        int mid;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (low == high) return (int)ar[mid - 1];
            if (check((int)ar[mid - 1], ind) != check((int)ar[mid], ind)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int)ar[ans - 1];
    }
    public static int check (int l, int r) {
        System.out.println("? " + l + " " + r);
        System.out.flush();
        return sc.nextInt();
    }
}
