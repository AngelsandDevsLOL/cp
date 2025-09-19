package COCI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Srednji {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), b = sc.nextInt();
        int[] ar = new int[n + 1];
        int ind = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int input = sc.nextInt();
            if (input > b) ar[i] = 1;
            else if (input < b) ar[i] = -1;
            if (input == b) ind = i;
            ar[i] += ar[i - 1];
        }
        for (int i = ind; i <= n; i++) {
            if (hMap.containsKey(ar[i])) hMap.put(ar[i], hMap.get(ar[i]) + 1);
            else hMap.put(ar[i], 1);
        }
        int ans = 0;
        for (int i = 0; i < ind; i++) {
            if (hMap.containsKey(ar[i])) ans += hMap.get(ar[i]);
        }
        System.out.println(ans);
    }
}
