package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FrankandRoads {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt(), g = sc.nextInt();
        int[] groceryStores = new int[g];
        for (int i = 0; i < g; i++) {
            groceryStores[i] = sc.nextInt();
        }
        int[][] thing = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), l = sc.nextInt();
            thing[a][b]=l;
        }
        boolean[] vis = new boolean[n+1];
        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)1e9); dis[0] = 0;
        for (int i = 0; i <= n; i++) {
            int min = (int)1e9, u = -1;
            for (int j = 0; j <= n; j++) {
                if(!vis[j] && dis[j] < min) {
                    min = dis[j]; u = j;
                }
            }
            if (u == -1) break;
            vis[u] = true;
            for (int j = 0; j <= n; j++) {
                if (thing[u][j] > 0 && dis[j] > dis[u] + thing[u][j])
                    dis[j] = dis[u] + thing[u][j];
            }
        }
        int count = 0;
        for (int i = 0; i < g; i++) {
            if (dis[groceryStores[i]] <= t) {
                count++;
            }
        }
        System.out.println(count);
    }
    static class Pair {
        int x;
        int l;
        public Pair(int x, int l) {
            this.x = x;
            this.l = l;
        }
    }
}
