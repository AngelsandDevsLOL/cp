package CCC;

import java.util.*;
import java.io.*;

public class BobsTripPlan2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int[] array = new int[n+2];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i+1] = readInt();
            sum = sum + Math.abs(array[i+1] - array[i]);
        }
        sum = sum + Math.abs(array[array.length-2]-0);
        for (int i = 0; i < n; i++) {
            int tempSum = sum;
            tempSum = tempSum - Math.abs(array[i+1] - array[i]);
            tempSum = tempSum - Math.abs(array[i+2] - array[i+1]);
            tempSum = tempSum + Math.abs(array[i+2] - array[i]);
            System.out.println(tempSum);
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