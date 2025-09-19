package CCC.Junior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChooseYourOwnPath {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> endPages = new ArrayList<>();
        ArrayList[] ar = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            ar[i] = new ArrayList();
            for (int j = 0; j < m; j++) {
                ar[i].add(scanner.nextInt());
            }
            if (m == 0) {
                endPages.add(i);
            }
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[n];
        q.add(0);
        vis[0] = true;
        dis[0] = 1;
        while (!q.isEmpty()) {
            int current = q.poll();
            ArrayList<Integer> aL = ar[current];
            for (int i = 0; i < aL.size(); i++) {
                if (!vis[aL.get(i)-1]) {
                    vis[aL.get(i)-1] = true;
                    q.add(aL.get(i)-1);
                    dis[aL.get(i)-1] = dis[current]+1;
                }
            }
        }
        boolean bool = true;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bool = false;
                break;
            }
        }
        if (bool) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        int x = n+1;
        for (int i = 0; i < endPages.size(); i++) {
            if (dis[endPages.get(i)] != 0) {
                x = Math.min(dis[endPages.get(i)], x);
            }
        }
        System.out.println(x);
    }
}
