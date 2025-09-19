package USACO;

import java.util.Scanner;

public class ComfortableCows {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sz = 1000;
        int[][] grid = new int[sz+4][sz+4], dif = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean [][] cow = new boolean[sz+4][sz+4];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt() + 1;
            int y = scanner.nextInt() + 1;
            cow[x][y] = true;
            for (int j = 0; j < 4; j++) {
                int nx = x + dif[j][0], ny= y + dif[j][1];
                grid[nx][ny]++;
                if(grid[nx][ny]==3 && cow[nx][ny]) ans++;
                if (grid[nx][ny] == 4 && cow[nx][ny]) ans--;
            }
            System.out.println(ans);
        }
    }
}
