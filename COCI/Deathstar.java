package COCI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Deathstar {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = nextInt();
                matrix[i][j] = x;
            }
        }
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < i; j++) {
                x = x | matrix[j][i];
            }
            for (int j = i + 1; j < n; j++) {
                x = x | matrix[i][j];
            }
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static String next () throws IOException {
        ArrayList<Integer> aList = new ArrayList<>();
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
