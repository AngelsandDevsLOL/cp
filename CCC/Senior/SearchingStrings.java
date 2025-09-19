package CCC.Senior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SearchingStrings {
    static long mod = (long) (1e9+7);
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine(), M = sc.nextLine();
        int n = N.length(), m = M.length();
        int[] fn = new int[26];
        int[] fh = new int[26];
        for (int i = 0; i < n; i++) {
            fn[N.charAt(i) - 'a']++;
        }
        long[] hs1 = new long[m + 1];
        long[] hs2 = new long[m + 1];
        long[] pw1 = new long[m + 1];
        long[] pw2 = new long[m + 1];
        pw2[0] = 1; pw1[0] = 1;
        HashMap<Long, HashSet<Long>> hMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            hs1[i] = (hs1[i - 1] * 131 + M.charAt(i - 1)) % mod;
            hs2[i] = (hs2[i - 1] * 10007 + M.charAt(i - 1)) % mod;
            pw1[i] = pw1[i - 1] * 131 % mod;
            pw2[i] = pw2[i - 1] * 10007 % mod;
        }
        for (int i = 0; i < m; i++) {
            fh[M.charAt(i) - 'a']++;
            if (i >= n) {
                fh[M.charAt(i - n) -'a']--;
            }
            if (Arrays.equals(fn, fh)) {
                int l = i - n + 2, r = i + 1;
                long sub1 = (hs1[r] - hs1[l - 1] * pw1[r - l + 1] % mod + mod) % mod;
                long sub2 = (hs2[r] - hs2[l - 1] * pw2[r - l + 1] % mod + mod) % mod;
                if (hMap.containsKey(sub1)) hMap.get(sub1).add(sub2);
                else {
                    HashSet<Long> hSet = new HashSet<>();
                    hSet.add(sub2);
                    hMap.put(sub1, hSet);
                }
            }
        }
        long sum = 0;
        for (long x : hMap.keySet()) {
            sum += hMap.get(x).size();
        }
        System.out.println(sum);
    }
}
