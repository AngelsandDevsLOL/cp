package AlphaStar;

import java.io.*;
import java.util.*;

public class DoYouKnowYourABCs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int t = readInt();
        for (int i = 0; i < t; i++) {
            int n = readInt();
            int[] ar2 = new int[n + 1];
            for (int j = 0; j < n; j++) {
                ar2[j] = readInt();
            }
            Arrays.sort(ar2);
            HashSet<Integer> set = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int j = 0; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    set.add(ar2[k] - ar2[j]);
                }
                if (j == n) break;
                set2.add(ar2[j + 1]);
            }
            int counter = 0;
            int[] ar = new int[set.size()];
            for (int x : set) {
                ar[counter++] = x;
            }
            int ans = 0;
            for (int j = 0; j < set.size(); j++) {
                for (int k = j; k < set.size(); k++) {
                    for (int l = k; l < set.size(); l++) {
                        int a = ar[j], b = ar[k], c = ar[l];
                        int count = 0;
                        HashMap<Integer, Integer> hMap = new HashMap<>();
                        if (!hMap.containsKey(a) && set2.contains(a)) {
                            hMap.put(a, 1);
                            count++;
                        }
                        if (!hMap.containsKey(b) && set2.contains(b)) {
                            hMap.put(b, 1);
                            count++;
                        }
                        if (!hMap.containsKey(c) && set2.contains(c)) {
                            hMap.put(c, 1);
                            count++;
                        }
                        if (!hMap.containsKey(a + b) && set2.contains(a + b)) {
                            hMap.put(a + b, 1);
                            count++;
                        }
                        if (!hMap.containsKey(a + c) && set2.contains(a + c)) {
                            hMap.put(a + c, 1);
                            count++;
                        }
                        if (!hMap.containsKey(b + c) && set2.contains(b + c)) {
                            hMap.put(b + c, 1);
                            count++;
                        }
                        if (!hMap.containsKey(a + b + c) && set2.contains(a + b + c)) {
                            hMap.put(a + b + c, 1);
                            count++;
                        }
                        if (count == n) ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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
