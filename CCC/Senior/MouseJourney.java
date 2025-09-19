package CCC.Senior;

import java.util.Scanner;

public class MouseJourney {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        boolean[][] vis = new boolean[r + 1][c + 1];
        int[][] dis = new int[r + 1][c + 1];
        int t = sc.nextInt();
        dis[1][1] = 1;
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            vis[x][y] = true;
        }
        for (int i = 3; i <= r + c; i++) {
            for (int x = 1; x <= r; x++) {
                int y = i - x;
                if (y > c || y < 1 || vis[x][y]) continue;
                dis[x][y] += dis[x - 1][y] + dis[x][y - 1];
            }
        }
        System.out.println(dis[r][c]);
    }
}
