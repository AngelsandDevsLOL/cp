package Random;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class PrimeTime  {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int y = 1;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            for (int k = y+1; k <= n; k++) {
                primeFactorize(k, tMap);
            }
            String str = "";
            for (int x : tMap.keySet()) {
                str = str  + " * " + x + "^" + tMap.get(x);
            }
            System.out.println(str.substring(3));
            y = n;
        }
    }
    public static boolean isPrime(int x) {
        boolean bool = true;
        if (x > 2 && x % 2 == 0) bool = false;
        for (int i = 3; i <= Math.sqrt(x); i = i + 2) {
            if (x % i == 0) bool = false;
        }
        return bool;
    }
    public static void primeFactorize (int n, TreeMap<Integer, Integer> tMap) {
        if (!isPrime(n)) {
            while (n % 2 == 0) {
                n = n / 2;
                if (tMap.containsKey(2)) {
                    tMap.put(2, tMap.get(2)+1);
                } else {
                    tMap.put(2, 1);
                }
            }
        }
        for (int j = 3; j <= Math.sqrt(n); j = j + 2) {
            while (n % j == 0) {
                n = n / j;
                if (tMap.containsKey(j)) {
                    tMap.put(j, tMap.get(j) + 1);
                } else {
                    tMap.put(j, 1);
                }
            }

        }
        if (tMap.containsKey(n)) {
            tMap.put(n, tMap.get(n) + 1);
        } else if (n != 1) {
            tMap.put(n, 1);
        }

    }}
