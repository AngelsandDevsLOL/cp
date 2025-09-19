package CCC.Senior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PhonomenalReviews2 {
    static ArrayList<Integer>[] aList;
    static boolean pho[];
    static int length;
    static int max = 0;
    static int index = 0;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        pho = new boolean[n+1];
        int restaurant=0;
        for (int i = 0; i < m; i++) {
            restaurant = scanner.nextInt();
            pho[restaurant] = true;
        }
        length = n;
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
        remove(restaurant, -1);
        bfs(restaurant);
        max = 0;
        bfs(index);
        System.out.println(length * 2 - max - 2);
    }
    public static boolean remove(int current, int past) {
        for (int i : aList[current]) {
            if (i != past) {
                if (remove(i, current)) {
                    pho[current] = true;
                }
            }
        }
        if (!pho[current]) length--;
        return pho[current];
    }
    static int[] bfs(int ind) {
        Queue<Integer> q = new LinkedList<>();
        q.add(ind);
        int[] dis = new int[aList.length];
        boolean[] vis = new boolean[aList.length];
        vis[ind] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : aList[cur]) {
                if (!vis[i] && pho[i]) {
                    vis[i] = true;
                    dis[i] = dis[cur] + 1;
                    if (dis[i] > max) {
                        max = dis[i];
                        index = i;
                    }
                    q.add(i);
                }
            }
        }
        return dis;
    }
}
