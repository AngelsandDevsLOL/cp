package Random;

import java.util.ArrayList;
import java.util.Scanner;

public class RunningInCircles {
    static int maxLength = 0;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            ArrayList<Integer>[] ar = new ArrayList[101];
            for (int j = 0; j < 101; j++) {
                ar[j] = new ArrayList<>();
            }
            int first = 0;
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                ar[a].add(b);
                if (j == 0) first = a;
            }
            maxLength = 0;
            recursion(ar, new int[101], new boolean[101], first, first);
            System.out.println(maxLength);
        }
    }
    static void recursion (ArrayList[] aList, int[] dis, boolean[] vis, int cur, int past) {
        if (vis[cur]) {
            if (dis[past] - dis[cur] + 1 > maxLength) {
                maxLength = dis[past] - dis[cur] + 1;
            }
            return;
        }
        ArrayList<Integer> al = aList[cur];
        vis[cur] = true;
        dis[cur] = dis[past] + 1;
        for (int i : al) {
            recursion(aList, dis, vis, i, cur);
        }
    }
}