package CCC.Junior;

import java.util.Scanner;

public class CrossSpiral {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(), r = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), step = sc.nextInt();
        int vis[][] = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if ((1 <= i && i <= y || r - y < i && i <= r) && (1 <= j && j <= x || c - x < j && j <= c)) {
                    vis[i][j] = -1;
                }
            }
        }
        int curr = 1, curc = x + 1, dir = 0;
        int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int i = 1; i <= step; i++) {
            vis[curr][curc] = 1;
            dir = (dir + 2) % 4;
            boolean stuck = true;
            for (int j = 0; j < 3; j++) {
                dir = (dir + 1) % 4;
                int nr = curr+ d[dir][0], nc = curc + d[dir][1];
                if (nr >= 1 && nr <= r && nc >= 1 && nc <= c && vis[nr][nc] == 0) {
                    curr = nr;
                    curc = nc;
                    stuck = false; break;
                }
            }
            if (stuck) break;
        }
        System.out.println(curc);
        System.out.println(curr);
    }
}
