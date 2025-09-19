package CCC;

import java.util.*;
import java.io.*;

public class NotEnoughTesters {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int t = readInt();
        int[] f = new int[100001];
        for (int i = 2; i < f.length; i++) {
            for (int j = i; j < f.length; j = j + i) {
                f[j]++;
            }
        }
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
        for (int i = 0; i < f.length; i++) {
            int factors = f[i];
            if (hMap.containsKey(factors)) hMap.get(f[i]).add(i);
            else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                hMap.put(f[i], aList);
            }
        }
        for (int i = 0; i < t; i++) {
            int k = readInt() - 1;
            int a = readInt();
            int b = readInt();
            if (hMap.get(k) != null) {
                ArrayList<Integer> aList = hMap.get(k);
                int x = Collections.binarySearch(aList,a);
                int y = Collections.binarySearch(aList, b);
                if (x < 0) {
                    x = (-x -1);
                }
                if (y < 0) {
                    y = (-y -2);
                }
                System.out.println(y - x+1);
            } else System.out.println(0);
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
