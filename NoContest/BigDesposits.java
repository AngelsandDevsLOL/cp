package NoContest;

import java.io.*;
import java.util.*;

public class BigDesposits {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        double p = readDouble() / 100 + 1;
        int y = readInt();
        long t = readLong(); // find n
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid;
        long temp = (long) (((1 - Math.pow(p, y)) / (1 - p)) * p);
        while (low < high) {
            mid = (low + high) / 2;
            long num = total(p,temp, mid);
            if (num > t) {
                high = mid;
            } else if (num < t) {
                low = mid + 1;
            } else {
                break;
            }
        }
        mid = (low + high) / 2;
        System.out.println(mid);
    }
    public static long total (double p, long temp, int n) {
        return (long) (n * temp);
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
    public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[columnNumber-1] > second[columnNumber-1]) return 1;
                else return -1;
            }
        });
    }
}