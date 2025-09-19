package CCC.MockJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mathland {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int exitX = 0;
        int exitY = 0;
        int[][][] dis = new int[n][n][4]; // 4 rotations
        sc.nextLine();
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String x = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (x.charAt(j) == 'W') {
                    dis[i][j][0] = -2;
                } else if (x.charAt(j) == 'X') {
                    exitX = i; exitY = j;
                } else if (x.charAt(j) == 'E') {
                    dis[i][j][0] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[][] ar = new int[][]{{0, 1}, {0, -1}, {1,0}, {-1, 0}};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (dis[p.x][p.y][p.z] % k == 0) { // a new rotation!
                int[] cur = newPoint(dis[p.x][p.y][p.z], p.x, p.y, k, n);
                if (dis[cur[0]][cur[1]][0] == -2) continue; // current node cannot go here for the rotation
            }
            for (int i = 0; i < 4; i++) {
                if (check(p.x + ar[i][0], p.y + ar[i][1], n)) {
                    int distance = 1 + dis[p.x][p.y][p.z];
                    int[] coord = newPoint(distance - 1, p.x + ar[i][0], p.y + ar[i][1], k, n);
                    if (dis[coord[0]][coord[1]][0] != -2 && (dis[p.x + ar[i][0]][p.y + ar[i][1]][coord[2]] > distance || dis[p.x + ar[i][0]][p.y + ar[i][1]][coord[2]] == 0)) {
                        dis[p.x + ar[i][0]][p.y + ar[i][1]][coord[2]] = distance;
                        q.add(new Pair(p.x + ar[i][0], p.y + ar[i][1], coord[2]));
                    }/*
                    for (int j = 1; j < 4; j++) { // wait to find out!
                        int[] cur = newPoint((distance - 1) / k * k + (j * k), p.x, p.y, k, n);
                        if (dis[cur[0]][cur[1]][0] == -2) break; // current node cannot go here for the rotation
                        int[] coord2 = newPoint((distance - 1) / k * k + (j * k), p.x + ar[i][0], p.y + ar[i][1], k, n);
                        if (dis[coord2[0]][coord2[1]][0] != -2 && (dis[p.x + ar[i][0]][p.y + ar[i][1]][coord2[2]] == 0 || dis[p.x + ar[i][0]][p.y + ar[i][1]][coord2[2]] > (distance - 1) / k * k + (j * k) + 1)) {
                            dis[p.x + ar[i][0]][p.y + ar[i][1]][coord2[2]] = (distance - 1) / k * k + (j * k) + 1;
                            q.add(new Pair(p.x + ar[i][0], p.y + ar[i][1], coord2[2]));
                        }
                    }*/
                }
            }
        }

        System.out.println(Math.min(Math.min(dis[exitX][exitY][0] == 0 ? Integer.MAX_VALUE : dis[exitX][exitY][0], dis[exitY][n - exitX - 1][1] == 0 ? Integer.MAX_VALUE : dis[exitY][n - exitX - 1][1]), Math.min(dis[n - 1 - exitX][n - 1 - exitY][2] == 0 ? Integer.MAX_VALUE : dis[n - 1 - exitX][n - 1 - exitY][2], dis[n - 1 - exitY][exitX][3] == 0 ? Integer.MAX_VALUE : dis[n - 1 - exitY][exitX][3])) - 1);
    }
    public static int[] newPoint (int curDis, int curX, int curY, int k, int n) {
        int num = curDis / k;
        if (num % 4 == 0) {
            return new int[]{curX, curY, 0};
        }  else if (num % 4 == 1) {
            // 270 clockwise or 90 counter clockwise
            return new int[]{n - 1 - curY, curX, 1};
        } else if (num % 4 == 2) { // 180
            return new int[]{n - 1 - curX, n - 1 - curY, 2};
        } else { // 90
            return new int[]{curY, n - curX - 1, 3};
        }
    }
    public static boolean check (int x, int y, int n) {
        if (x >= 0 && y >= 0 && x < n && y < n) return true;
        return false;
    }
    public static class Pair {
        int x;
        int y;
        int z;
        public Pair (int xx, int yy, int zz) {
            x = xx; y = yy; z = zz;
        }
    }
}
