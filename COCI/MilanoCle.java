package COCI;

import java.util.*;

public class MilanoCle {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            tMap.put(ar[i], sc.nextInt());
        }
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int x : tMap.keySet()) {
            int number = tMap.get(x);
            if (tSet.isEmpty() || tSet.ceiling(number) == null){
                tSet.add(number);
            } else {
                int num = tSet.ceiling(number);
                tSet.remove(num);
                tSet.add(number);
            }
        }
        System.out.println(tSet.size());
    }
}
