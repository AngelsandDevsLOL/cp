package CCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BobsDifferentSum {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        int n = readInt();
        int[] input = new int[n];
        long sum = (n * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
            input[i] = readInt();
        }
        sum = 0;
        int temp = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = (input[i] - input[j]);
                sum = sum + Math.abs(temp);
                x++;
            }
        }
        System.out.println(sum);
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
