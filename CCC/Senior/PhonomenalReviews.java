package CCC.Senior;

import java.util.ArrayList;
import java.util.Scanner;

public class PhonomenalReviews {
    static ArrayList<Integer>[] aList;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] pho = new int[m];
        int restaurant=0;
        for (int i = 0; i < m; i++) {
            pho[i] = scanner.nextInt();
            restaurant = pho[i];
        }
        aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            aList[a].add(b);
            aList[b].add(a);
        }
        int[] dis = new int[n+1];
        dfs(restaurant, dis, new boolean[n+1]);
        int index = 1;
        int max = dis[1];
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] > max) {
                max = dis[i];
                index = i;
            }
        }
        dis = new int[n+1];
        dfs(index, dis, new boolean[n+1]);
        int index2 = 1;
        max = dis[1];
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] > max) {
                max = dis[i];
                index2 = i;
            }
        }
        int[] dis2 = new int[n+1];
        dfs(index2, dis2, new boolean[n+1]);
        int dist = dis2[index];
        long sum = dist;
        for (int i = 0; i < pho.length; i++) {
            sum = sum + (dis[pho[i]] + dis[pho[i]] - dist);
        }
        System.out.println(sum);
    }
    static void dfs(int current, int[] dis, boolean[] vis) {
        vis[current] = true;
        for (int i : aList[current]) {
            if (!vis[i]) {
                dis[i] = dis[current] + 1;
                dfs(i, dis, vis);
            }
        }
    }
}
