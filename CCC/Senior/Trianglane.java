package CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Trianglane {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        boolean[][] ar = new boolean[2][c];
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < c; j++) {
                ar[i][j] = sc.nextInt() == 1;
                if (ar[i][j]) count++;
            }
        }
        int count2 = 0;
        if (ar[0][0] && ar[1][0]) count2++;
        for (int i = 1; i < c; i++) {
            if (ar[0][i-1] && ar[0][i]) count2++;
            if (ar[1][i - 1] && ar[1][i]) count2++;
            if (ar[0][i] && ar[1][i] && i % 2 == 0) count2++;
        }
        System.out.println(count * 3 - count2 * 2);
    }
    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
