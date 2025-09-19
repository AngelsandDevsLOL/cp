package DMOPC;

import java.util.*;
import java.io.*;

public class PermutationsProducts {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        HashSet<Integer> hSet = new HashSet<>();
        int[] multiple = new int[n];
        int[] array = new int[n];
        for (int i = 0; i < n - 1; i++) {
            System.out.println("? " + (i+1) + " " + (i+2));
            System.out.flush();
            multiple[i] = readInt();
            hSet.add(i+1);
        }
        HashMap<Integer, HashSet<Integer>> hMap = new HashMap<>();
        hSet.add(n);
        int x = 0;
        System.out.println("? " + 1 + " " + 3);
        System.out.flush();
        x = readInt();
        for (int i = 0; i < n-2; i++) {
            int a = multiple[i];
            int b = multiple[i+1];
            int number = Math.min(a,b);
            HashSet<Integer> factors = new HashSet<>();
            HashSet<Integer> factors2 = new HashSet<>();
            if (hMap.containsKey(i)) {
                factors = hMap.get(i);
            }
            for (int j = 2; j <= Math.min(number, n); j++) {
                if (a % j == 0 && b % j == 0) {
                    factors.add(j);
                    factors2.add(j);
                }
            }
            if (hMap.containsKey(i)) {
                hMap.replace(i, factors);
            } else {
                hMap.put(i, factors);
            }
            hMap.put(i+1, factors2);
        }
        int b = multiple[2];
        int number = Math.min(x,b);
        HashSet<Integer> factors = new HashSet<>();
        for (int j = 2; j <= Math.min(number, n); j++) {
            if (x % j == 0 && b % j == 0) {
                factors.add(j);
            }
        }
        HashSet<Integer> hashSet = hMap.get(1);
        for (int integer : hashSet) {
            if (!factors.contains(integer)) {
                hashSet.remove(integer);
            }
        }
        hMap.replace(1, hashSet);
        hashSet = hMap.get(3);
        for (int integer : hashSet) {
            if (!factors.contains(integer)) {
                hashSet.remove(integer);
            }
        }
        hMap.replace(3, hashSet);
        for (int i = 0; i < n; i++) {
            factors = hMap.get(i);
            if (factors != null && factors.size() != 1) {
                for (int integerr : factors) {
                    if (!hSet.contains(integerr)) {
                        factors.remove(integerr);
                    }
                }
            }
            if (factors != null && factors.size() == 1) {
                for (int integer : factors) {
                    array[i] = integer;
                    hSet.remove(integer);
                    break;
                }
            }
        }
        System.out.print("! ");
        for (int i = 0; i < n-1; i++) {
            System.out.print(array[i] + " ");
        }
        for (int integer : hSet) {
            System.out.print(integer);
            break;
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}