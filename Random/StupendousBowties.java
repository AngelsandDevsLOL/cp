package Random;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class StupendousBowties {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, TreeSet<Integer>> x = new HashMap<>();
        HashMap<Integer, TreeMap<Integer, Integer>> y = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (!x.containsKey(a)) {
                TreeSet<Integer> tSet = new TreeSet<>();
                tSet.add(b);
                x.put(a, tSet);
            } else {
                x.get(a).add(b);
            }
            if (!y.containsKey(b)) {
                TreeMap<Integer, Integer> tSet = new TreeMap<>();
                tSet.put(a, 0);
                y.put(b, tSet);
            } else {
                y.get(b).put(a, 0);
            }
        }
        for (int b : y.keySet()) {
            int count = 0;
            for (int a : y.get(b).keySet()) {
                y.get(b).put(a, count++);
            }
        }
        long ans = 0;
        for (int a : x.keySet()) {
            int num = 0;
            for (int b : x.get(a)) {
                // up = num
                int down = x.get(a).size() - num - 1;
                int left = y.get(b).get(a);
                int right = y.get(b).size() - left - 1;
                ans += (long) 2 * num * down * left * right;
                num++;
            }
        }
        System.out.println(ans);
    }
}
