package Random;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Inflation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long, Integer> hMap = new HashMap<>();
        long cur = 0;
        long infl = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            cur += p;
            if (hMap.containsKey( (long) p)) {
                hMap.put((long)p, hMap.get((long)p) + 1);
            } else {
                hMap.put((long)p, 1);
            }
        }
        int q = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("INFLATION")) {
                infl += Long.parseLong(input[1]);
                cur += Long.parseLong(input[1]) * n;
                System.out.println(cur);
            } else {
                long x = Long.parseLong(input[1]);
                long y = Long.parseLong(input[2]);
                if (hMap.containsKey(x - infl)) {
                    int amt = hMap.get(x - infl);
                    hMap.remove(x - infl);
                    if (hMap.containsKey(y - infl)) {
                        hMap.put(y - infl, hMap.get(y - infl) + amt);
                    } else {
                        hMap.put(y - infl, amt);
                    }
                    cur += (y - x) * amt;
                    System.out.println(cur);
                } else {
                    System.out.println(cur);
                }
            }
        }
    }
}
