package USACO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConveyorBelt {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[][] ar = new int[n][n];
        int[][] dead = new int[n][n]; // sets
        int ans = 0;
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < q; i++) { // check what comes next, check who comes before
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]); int y = Integer.parseInt(input[1]);
            if (input[2].charAt(0) == 'L') ar[x][y] = 1;
            else if (input[2].charAt(0) == 'R') ar[x][y] = 4;
            else if (input[2].charAt(0) == 'U') ar[x][y] = 2;
            else if (input[2].charAt(0) == 'D') ar[x][y] = 3;
            int[] next = new int[]{x + direction[ar[x][y] - 1][0], y + direction[ar[x][y] - 1][1]};
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x); queue.add(y);
            if (dead[x][y] != 0) continue; // doesn't matter what I do ..
            if (dead[next[x]][next[y]] != 0) {
                dead[x][y] = dead[next[x]][next[y]];
                while (!queue.isEmpty()) {
                    int xx = queue.poll();
                    int yy = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int nextX = xx + direction[j][0];
                        int nextY = yy + direction[j][1];
                        if (ar[nextX][nextY] == 0) { // trapped

                        } else if (nextX + direction[ar[nextX][nextY] - 1][0] == xx && nextY + direction[ar[nextX][nextY] - 1][1] == yy) {
                            queue.add(nextX); queue.add(nextY);
                            dead[nextX][nextY] = dead[xx][yy];
                            ans++;
                        }
                    }
                }
            }
            else if (ar[next[x]][next[y]] == 0) {
                // yay nothing to do
            } else {
                boolean sad = false;
                for (int j = 0; j < 4; j++) {
                    int nextX = x + direction[j][0];
                    int nextY = y + direction[j][1];
                    if (nextX + direction[ar[nextX][nextY] - 1][0] == x && nextY + direction[ar[nextX][nextY] - 1][1] == y) {
                        sad = true;
                    }
                }
                if (sad) {

                }
            }
        }
    }
    public static boolean exists (int x, int y, int n) {
        if (x >= 0 && y >= 0 && x < n && y < n) return true;
        return false;
    }
}
