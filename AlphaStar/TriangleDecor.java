package AlphaStar;

import java.util.*;
import java.io.*;

public class TriangleDecor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = readInt(), y = readInt();
            ar[i][0] = x - y; ar[i][1] = x + y;
        }
        Arrays.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return -Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        int ans = n;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (ar[i][1] > max) {
                max = ar[i][1];
            } else ans--;
        }
        System.out.println(ans);
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
