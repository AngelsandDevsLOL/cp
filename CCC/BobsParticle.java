package CCC;

import java.util.*;
import java.io.*;

public class BobsParticle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int count = 0;
        int[][] white = new int[n][2];
        int[][] black = new int[n][2];
        for (int i = 0; i < n; i++) {
            white[i][0] = readInt();
            white[i][1] = readInt();
        }
        for (int i = 0; i < n; i++) {
            black[i][0] = readInt();
            black[i][1] = readInt();
        }
        Sort2DArrayBasedOnColumnNumber(white, 1);
        Sort2DArrayBasedOnColumnNumber(black, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean bool = true;
                if (black[i][0] > white [j][0] && black[i][1] > white[j][1]) {
                    count++;
                    bool = false;
                }
                if (bool != true) {
                    white[j][0] = 100001;
                    break;
                }
            }
        }
        System.out.println(count);
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