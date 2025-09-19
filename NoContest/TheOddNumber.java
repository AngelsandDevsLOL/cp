package NoContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheOddNumber {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int odd = 0;

        for (int i = 0; i < n; i++) {
            int num = readInt();
            odd ^= num;
        }

        System.out.println(odd);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
