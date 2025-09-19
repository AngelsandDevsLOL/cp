package Random;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TombRobbing {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        boolean[][] possible = new boolean[r][c];
        scanner.nextLine();
        for (int i = 0; i < r; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == '.') {
                    possible[i][j] = true;
                }
            }
        }
        boolean[][] vis = new boolean[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (possible[i][j] && !vis[i][j]) {
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        if (cur.x + 1 < r && possible[cur.x+1][cur.y] && !vis[cur.x+1][cur.y]) {
                            q.add(new Pair(cur.x+1, cur.y));
                            vis[cur.x+1][cur.y] = true;
                        }
                        if (cur.y + 1< c && possible[cur.x][cur.y+1] && !vis[cur.x][cur.y+1]) {
                            q.add(new Pair(cur.x, cur.y + 1));
                            vis[cur.x][cur.y+1] = true;
                        }
                        if (cur.x - 1 >= 0 && possible[cur.x-1][cur.y] && !vis[cur.x-1][cur.y]) {
                            q.add(new Pair(cur.x-1, cur.y));
                            vis[cur.x-1][cur.y] = true;
                        }
                        if (cur.y - 1 >= 0 && possible[cur.x][cur.y-1] && !vis[cur.x][cur.y-1]) {
                            q.add(new Pair(cur.x, cur.y-1));
                            vis[cur.x][cur.y-1] = true;
                        }
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
