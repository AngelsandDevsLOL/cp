package CCC.MockS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RogerSaysYabe {
    public static HashSet<String> hSet = new HashSet<>();
    public static HashSet<String> hSet2 = new HashSet<>();
    public static boolean[] destination;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt(), m = sc.nextInt();
        destination = new boolean[n + 1];
        for (int i = 0; i < d; i++) {
            destination[sc.nextInt()] = true;
        }
        ArrayList<Pair>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            aList[Integer.parseInt(input[0])].add(new Pair(input[1].charAt(0), Integer.parseInt(input[2])));
        }
        dfs(new StringBuilder(), aList, 1, new boolean[n + 1]);
    }
    static class Pair {
        char x;
        int y;
        public Pair (char x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void dfs (StringBuilder x, ArrayList<Pair>[] aList, int cur, boolean[] vis) {
        if (destination[cur]) {
            hSet.add(x.toString());
        }
        for (Pair p : aList[cur]) {
            if (!vis[p.y]) {
                vis[p.y] = true;
                x.append(p.x);
                dfs(x, aList, p.y, vis);
            }
        }
    }
}
