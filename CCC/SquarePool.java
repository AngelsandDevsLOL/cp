package CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SquarePool {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int t = readInt() + 2;
        int[] rows = new int[t];
        int[] cols = new int[t];
        rows[t - 1] = n + 1;
        cols[t - 1] = n + 1;
        for (int i = 0; i < t - 2; i++) {
            int r = readInt(); int c = readInt();
            rows[i] = r;
            cols[i] = c;
        }
        int m = 0;
        for (int i = 0; i < t; i++) {
            for (int j = i + 1; j < t; j++) {
                int left = Math.min(cols[i], cols[j]), right = Math.max(cols[i], cols[j]);
                int width = right - left - 1;
                ArrayList<Integer> aList = new ArrayList<>();
                for (int k = 0; k < t; k++) {
                    if (cols[k] > left && cols[k] < right) {
                        aList.add(rows[k]);
                    }
                }
                aList.add(0);
                aList.add(n + 1);
                Collections.sort(aList);
                int max = 0;
                for (int k = 1; k < aList.size(); k++) {
                    max = Math.max(aList.get(k) - aList.get(k-1) - 1, max);
                }
                m = Math.max(m, Math.min(max, width));
            }
        }
        System.out.println(m);
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
