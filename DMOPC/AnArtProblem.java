package DMOPC;

import java.util.*;

public class AnArtProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] ar = new int[n][m];
        HashMap<Integer, ArrayList<Pair>> hMap = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            hMap.put(i, new ArrayList<Pair>());
        }
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = scanner.nextInt();
                if (ar[i][j] != 0) {
                    hMap.get(ar[i][j]).add(new Pair(i,j, 0));
                    vis[i][j] = true;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            ArrayList<Pair> aList = hMap.get(i);
            if (aList == null) continue;
            for (Pair p : aList) {
                q.add(p);
            }
            while (!q.isEmpty()) {
                Pair cur = q.poll();
                if (cur.z == k) {
                    q = new LinkedList<>();
                    break;
                }
                if (cur.x - 1 >= 0 && !vis[cur.x - 1][cur.y]) {
                    vis[cur.x - 1][cur.y] = true;
                    q.add(new Pair(cur.x-1, cur.y, cur.z+1));
                    ar[cur.x-1][cur.y] = i;
                }
                if (cur.x + 1 < n && !vis[cur.x + 1][cur.y]) {
                    vis[cur.x + 1][cur.y] = true;
                    q.add(new Pair(cur.x+1, cur.y, cur.z+1));
                    ar[cur.x+1][cur.y] = i;
                }
                if (cur.y - 1 >= 0 && !vis[cur.x][cur.y - 1]) {
                    vis[cur.x][cur.y - 1] = true;
                    q.add(new Pair(cur.x, cur.y - 1,cur.z+1));
                    ar[cur.x][cur.y - 1] = i;
                }
                if (cur.y + 1 < m && !vis[cur.x][cur.y + 1]) {
                    vis[cur.x][cur.y + 1] = true;
                    q.add(new Pair(cur.x, cur.y + 1,cur.z+1));
                    ar[cur.x][cur.y + 1] = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
    static class Pair {
        int x;
        int y;
        int z;
        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
