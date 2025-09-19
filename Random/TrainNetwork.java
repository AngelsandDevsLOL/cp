package Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TrainNetwork {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            aList[u].add(v);
            aList[v].add(u);
        }
        int[] dis = bfs(aList, n, 1);
    /*    int largestIndex = 1;
        for (int i = 2; i < dis.length; i++) {
            if (dis[i] > dis[largestIndex]) {
                largestIndex = i;
            }
        }
        int[] dis2 = bfs(aList, n, largestIndex);
      */
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt(), b= sc.nextInt(), d = sc.nextInt();
            ArrayList<Integer>[] aList2 = aList.clone();
            for (int j = 0; j < dis.length; j++) {
                //if ()
            }
        }
    }
    public static int[] bfs(ArrayList<Integer>[] aList, int end, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] dis = new int[end + 1];
        boolean[] vis = new boolean[end + 1];
        vis[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int x : aList[cur]) {
                if (!vis[x]) {
                    dis[x] = dis[cur] + 1;
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return dis;
    }
}
