package CCC.Senior;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            scanner.nextLine();
            String[][] input = new String[r][c];
            for (int j = 0; j < r; j++) {
                String x = scanner.nextLine();
                for (int k = 0; k < c; k++) {
                    input[j][k] = x.substring(k,k+1);
                }
            }
            boolean[][] vis = new boolean[r][c];
            int[][] dis = new int[r][c];
            Queue<Pair> queue = new LinkedList<>();
            dis[0][0]  = 1;
            vis[0][0] = true;
            queue.add(new Pair(0,0));
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                if (input[pair.x][pair.y].equals("+")) {
                    if (pair.x + 1 < r && !vis[pair.x+1][pair.y])   {
                        vis[pair.x+1][pair.y] = true;
                        queue.add(new Pair(pair.x+1, pair.y));
                        dis[pair.x+1][pair.y] = dis[pair.x][pair.y] + 1;
                    }
                    if (pair.y + 1 < c && !vis[pair.x][pair.y+1])   {
                        vis[pair.x][pair.y+1] = true;
                        queue.add(new Pair(pair.x, pair.y+1));
                        dis[pair.x][pair.y+1] = dis[pair.x][pair.y] + 1;
                    }
                    if (pair.x - 1 >= 0 && !vis[pair.x-1][pair.y])   {
                        vis[pair.x-1][pair.y] = true;
                        queue.add(new Pair(pair.x-1, pair.y));
                        dis[pair.x-1][pair.y] = dis[pair.x][pair.y] + 1;
                    }
                    if (pair.y - 1 >= 0 && !vis[pair.x][pair.y-1])   {
                        vis[pair.x][pair.y-1] = true;
                        queue.add(new Pair(pair.x, pair.y-1));
                        dis[pair.x][pair.y-1] = dis[pair.x][pair.y] + 1;
                    }
                } else if (input[pair.x][pair.y].equals("-")) {
                    if (pair.y + 1 < c && !vis[pair.x][pair.y+1])   {
                        vis[pair.x][pair.y+1] = true;
                        queue.add(new Pair(pair.x, pair.y+1));
                        dis[pair.x][pair.y+1] = dis[pair.x][pair.y] + 1;
                    }
                    if (pair.y - 1 >= 0 && !vis[pair.x][pair.y-1])   {
                        vis[pair.x][pair.y-1] = true;
                        queue.add(new Pair(pair.x, pair.y-1));
                        dis[pair.x][pair.y-1] = dis[pair.x][pair.y] + 1;
                    }
                } else if (input[pair.x][pair.y].equals("|")) {
                    if (pair.x + 1 < r && !vis[pair.x+1][pair.y])   {
                        vis[pair.x+1][pair.y] = true;
                        queue.add(new Pair(pair.x+1, pair.y));
                        dis[pair.x+1][pair.y] = dis[pair.x][pair.y] + 1;
                    }
                    if (pair.x - 1 >= 0 && !vis[pair.x-1][pair.y])   {
                        vis[pair.x-1][pair.y] = true;
                        queue.add(new Pair(pair.x-1, pair.y));
                        dis[pair.x-1][pair.y] = dis[pair.x][pair.y] + 1;
                    }
                }
            }
            if (vis[r-1][c-1] && !input[r-1][c-1].equals("*")) {
                System.out.println(dis[r-1][c-1]);
            } else {
                System.out.println(-1);
            }
        }
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
    }
}
