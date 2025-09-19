package CCC;

import java.util.*;
import java.io.*;

public class BobsTeam {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        TreeMap<Integer, Long> tMap2 = new TreeMap<>();
        int[] al1 = new int[n];
        int[] al2 = new int[n];
        int[] al3 = new int[n];
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    al1[j] = readInt();
                }
            }
            if (i == 1) {
                for (int j = 0; j < n; j++) {
                    al2[j] = readInt();
                }
            }
            if (i == 2) {
                for (int j = 0; j < n; j++) {
                    al3[j] = readInt();
                }
            }
        }
        Arrays.sort(al1);
        Arrays.sort(al2);
        for (int i = 0; i < n; i++) {
            tMap.put(al1[i], i+1);
        }
        long sum = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> map = tMap.floorEntry(al2[i]-1);
            if (map != null) {
                sum = sum + map.getValue();
            }
            tMap2.put(al2[i], sum);
        }
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Long> map = tMap2.floorEntry(al3[i]-1);
            if (map != null) {
                count = count + map.getValue();
            }
        }
        System.out.println(count);
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