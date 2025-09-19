package Random;

import java.io.*;
import java.util.*;

public class ClubFairB {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt(), q = readInt(); long dis[] = new long[n];
        for(int i=0; i<n; i++) {
            long x = readLong(), y = readLong();
            dis[i] = x*x + y*y;
        }
        Arrays.sort(dis);
        for(int i=0; i<q; i++) {
            long r = readLong();
            System.out.println(binarySearch(dis, r*r));
        }
    }
    static int binarySearch(long dis[], long x) {//find 1st > x
        int lo = 0, hi = dis.length-1, ans = dis.length;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(dis[mid] > x) { ans = mid; hi = mid - 1; }
            else lo = mid + 1;
        }
        return ans;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}