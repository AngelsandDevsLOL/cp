package CCC.Junior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightHop {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        boolean[][] vis = new boolean[8][8];
        Queue<Pair> q = new LinkedList<>();
        int[][] dis = new int[8][8];
        q.add(new Pair(x1, y1));
        vis[x1-1][y1-1] = true;
        dis[x1-1][y1-1] = 1;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            ArrayList<Pair> aL = Knightpositions(current.getX(),current.getY());
            for (int i = 0; i < aL.size(); i++) {
                if (!vis[aL.get(i).getX()-1][aL.get(i).getY()-1]) {
                    vis[aL.get(i).getX()-1][aL.get(i).getY()-1] = true;
                    q.add(aL.get(i));
                    dis[aL.get(i).getX()-1][aL.get(i).getY()-1] = dis[current.getX()-1][current.getY()-1]+1;
                }
            }
        }
        System.out.println(dis[x2-1][y2-1]-1);
    }
    public static ArrayList<Pair> Knightpositions(int x, int y) {
        ArrayList<Pair> aList = new ArrayList<>();
        if (x - 2 >0) {
            if (y - 1 > 0) {
                aList.add(new Pair(x-2, y-1));
            } if (y + 1 <= 8) {
                aList.add(new Pair(x-2, y+1));
            }
        } else if (x - 1 > 0) {
            if (y - 2 > 0) {
                aList.add(new Pair(x-1, y-2));
            } if (y + 2 <= 8) {
                aList.add(new Pair(x-1, y+2));
            }
        } if (x + 2 <= 8) {
            if (y - 1 > 0) {
                aList.add(new Pair(x+2, y-1));
            } if (y + 1 <= 8) {
                aList.add(new Pair(x+2, y+1));
            }
        } if (x + 1 <= 8) {
            if (y - 2 > 0) {
                aList.add(new Pair(x+1, y-2));
            } if (y + 2 <= 8) {
                aList.add(new Pair(x+1, y+2));
            }
        }
        return aList;
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