package Random;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Oversleep {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        boolean[][] vis = new boolean[x][y];
        int destinationX = 0;
        int destinationY = 0;
        int currentX = 0;
        int currentY = 0;
        boolean[][] path = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < y; j++) {
                if (input.charAt(j) != 'X') {
                    path[i][j] = true;
                    if (input.charAt(j) == 'e') {
                        destinationX = i;
                        destinationY = j;
                    } else if (input.charAt(j) == 's') {
                        currentX = i;
                        currentY = j;
                    }
                }
            }
        }
        int[][] dis = new int[x][y];
        vis[currentX][currentY] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(currentX, currentY));
        vis[currentX][currentY] = true;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int cordx = pair.getX();
            int cordy = pair.getY();
            if (cordx +1 < x && !vis[cordx+1][cordy] && path[cordx+1][cordy]) {
                vis[cordx+1][cordy] = true;
                q.add(new Pair(cordx + 1, cordy));
                dis[cordx+1][cordy] = dis[cordx][cordy] + 1;
            }
            if (cordx -1 >= 0 && !vis[cordx-1][cordy] && path[cordx-1][cordy]) {
                vis[cordx-1][cordy] = true;
                q.add(new Pair(cordx - 1, cordy));
                dis[cordx-1][cordy] = dis[cordx][cordy] + 1;
            }
            if (cordy +1 < y && !vis[cordx][cordy + 1] && path[cordx][cordy + 1]) {
                vis[cordx][cordy + 1] = true;
                q.add(new Pair(cordx, cordy + 1));
                dis[cordx][cordy + 1] = dis[cordx][cordy] + 1;
            }
            if (cordy -1 >= 0 && !vis[cordx][cordy - 1] && path[cordx][cordy - 1]) {
                vis[cordx][cordy-1] = true;
                q.add(new Pair(cordx, cordy - 1));
                dis[cordx][cordy - 1] = dis[cordx][cordy] + 1;
            }
        }
        System.out.println(dis[destinationX][destinationY]);
    }
    static class Pair {
        int x;
        int y;
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
