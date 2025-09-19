package CCO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Artskjid2 {
    public static int[][] dis;
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); int m = sc.nextInt();
        dis = new int[n][(int)(1 << 18)];
        ArrayList<Pair>[] aList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int[] ar : dis) {
            Arrays.fill(ar, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt(), d = sc.nextInt(), l = sc.nextInt();
            aList[s].add(new Pair(d, l));
        }
        System.out.println(maxFun(0, 1, aList));
    }
    public static int maxFun (int x, int mask, ArrayList<Pair>[] aList) {
        if (x == n - 1) return 0;
        if (dis[x][mask] >= 0) return dis[x][mask];
        for (Pair p : aList[x]) {
            int num = (1 << p.x) | mask;
            if (num != mask) {
                dis[x][mask] = Math.max(dis[x][mask], maxFun(p.x, num, aList) + p.y);
            }
        }
        return dis[x][mask];
    }
    public static class Pair {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }
    }
}
