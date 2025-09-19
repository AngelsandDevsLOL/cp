package CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PalindromicPoster {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = nextInt(), m = nextInt(), r = nextInt(), c = nextInt();
        char[][] ar = new char[n][m];
        for (char[] rows : ar) {
            Arrays.fill(rows, 'a');
        }
        if (0 <= r && r < n && 0 <= c && c < m || (r == n && m == c) || (r == 0 && c == 0)) {
            for (int i = 0; i < n - r; i++) {
                ar[i][0]++; // might be the other side + 1
            }
            for (int i = 0; i < m - c; i++) {
                ar[0][i]++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ar[i][j]);
                }
                System.out.println();
            }
        } else if (r == 0 && c == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
            for (int i = 0; i < n; i++) {
                System.out.println(sb.toString());
            }
        } else if (c == 0 && r == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append("a");
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.println(sb.toString());
            }
            for (int i = 0; i < m; i++) {
                System.out.print("b");
            }
            System.out.println();
        } else if (m % 2 == 0 && r == n && c % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append("a");
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.println(sb.toString());
            }
            sb.delete(0, m);
            for (int i = 0; i < (m - c) / 2; i++) {
                sb.append("b");
            }
            for (int i = 0; i < c / 2; i++) {
                sb.append("a");
            }
            System.out.print(sb.toString());
            sb.reverse();
            System.out.println(sb.toString());
        } else if (m % 2 == 1 && r == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append("a");
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.println(sb.toString());
            }
            sb.delete(0, m);
            for (int i = 0; i < (m - c) / 2; i++) {
                sb.append("b");
            }
            for (int i = 0; i < c / 2; i++) {
                sb.append("a");
            }
            System.out.print(sb.toString());
            sb.reverse();
            if (c % 2 == 0) System.out.print("b");
            else System.out.print("a");
            System.out.println(sb.toString());
        } else if (n % 2 == 0 && c == m && r % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m - 1; i++) {
                sb.append("a");
            }
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i = 0; i < (n - r) / 2; i++) {
                sb2.append("b");
                sb3.append("b");
            }
            for (int i = 0; i < r / 2; i++) {
                sb2.append("a");
                sb3.append("a");
            }
            sb3.reverse();
            sb2.append(sb3);
            for (int i = 0; i < n; i++) {
                System.out.print(sb.toString());
                System.out.println(sb2.toString().charAt(i));
            }
        } else if (n % 2 != 0 && c == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m - 1; i++) {
                sb.append("a");
            }
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i = 0; i < (n - r) / 2; i++) {
                sb2.append("b");
                sb3.append("b");
            }
            for (int i = 0; i < r / 2; i++) {
                sb2.append("a");
                sb3.append("a");
            }
            sb3.reverse();
            sb2.append(sb3);
            int count = 0;
            for (int i = 0; i < n; i++) {
                System.out.print(sb.toString());
                if (i == n / 2) {
                    if (r % 2 == 0) {
                        System.out.println("b");
                    } else {
                        System.out.println("a");
                    }
                } else {
                    System.out.println(sb2.toString().charAt(count++));
                }
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}