package CCC.Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CombiningRiceballs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = nextInt();
        int[] dis = new int[n]; // psa
        int[] ar = new int[n];
        boolean[][] vis = new boolean[n][n]; // can it be simplified into one form?
        int x = nextInt();
        ar[0] = x; dis[0] = x;
        vis[0][0] = true;
        for (int i = 1; i < n; i++) {
            x = nextInt();
            ar[i] = x;
            dis[i] = x + dis[i - 1];
            vis[i][i] = true;
        }
        for (int i = 1; i < n; i++){ // size
            for (int j = 0; j < n - i; j++) { // (j, j + i) // starting
                int sumA = ar[j];
                int sumC = ar[i + j];

                int indA = j;
                int indC = i + j;

                while (indA < indC){
                    if (vis[j][indA] && (indC - 1 < indA + 1 || vis[indA + 1][indC - 1]) && vis[indC][i + j] && sumA == sumC){
                        vis[j][i + j] = true; break;
                    } if (sumA < sumC){
                        indA++;
                        sumA += ar[indA];
                    } else{
                        indC--;
                        sumC += ar[indC];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (vis[i][j]){
                    max = Math.max(max, dis[j] - dis[i] + ar[i]);
                }
            }
        }
        System.out.println(max);
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
