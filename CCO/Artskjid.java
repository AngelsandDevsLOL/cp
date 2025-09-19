package CCO;

import java.lang.*;
import java.util.*;

public class Artskjid {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int[] row : graph) {
            Arrays.fill(row, 300000);
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int l = sc.nextInt();
            if (s < d) {
                graph[s][d] = -1 * l;
            }
        }
        int i, j, k;
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
        System.out.println(-1 * graph[0][n - 1]);
    }
}


