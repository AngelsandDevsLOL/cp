package WLMOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class WeakestWarriors {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        TreeMap<Integer, ArrayList<Integer>> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (tMap.containsKey(a)) {
                tMap.get(a).add(0, i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                tMap.put(a, aList);
            }
        }
        int[] ar = new int[k];
        int count = 0;
        for (int x : tMap.keySet()) {
            for (int num : tMap.get(x)) {
                ar[count] = num;
                count++;
                if (count == k) break;
            }
            if (count == k) break;
        }
        Arrays.sort(ar);
        for (int i = 0; i < k; i++) {
            System.out.println(ar[i] + 1);
        }
    }
}
