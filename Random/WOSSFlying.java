package Random;

import java.util.ArrayList;
import java.util.Scanner;

public class WOSSFlying {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), l = sc.nextInt();
            aList[u].add(new Pair(v, l));
            aList[v].add(new Pair(u, l));
        }
        for (int i = 0; i < q; i++) {
            //int q = sc.nextInt(), c = sc.nextInt();
        }
    }
    public static class Pair {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }
    }
}
