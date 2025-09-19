package USACO;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        FileWriter writer = new FileWriter("buckets.out", true); // file writer
        BufferedWriter bw = new BufferedWriter(writer);
        int[][] dis = new int[10][10];
        boolean[][] vis = new boolean[10][10];
        Pair barn = new Pair(0,0);
        Pair lake = new Pair(0,0);
        for (int i = 0; i < 10; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.substring(j,j+1).equals("B")) {
                    barn.x = i; barn.y = j;
                    vis[i][j] = true;
                } else if (input.substring(j,j+1).equals("R")) {
                    vis[i][j] = true;
                } else if (input.substring(j,j+1).equals("L")) {
                    lake.x = i; lake.y = j;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(barn);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 || j == 0) {
                        if (cur.x + i >= 0 && cur.y + j >= 0 && cur.x + i < 10 && cur.y + j < 10 && !vis[cur.x + i][cur.y + j]) {
                            q.add(new Pair(cur.x+i,cur.y+j));
                            vis[cur.x+i][cur.y+j] = true;
                            dis[cur.x+i][cur.y+j] = dis[cur.x][cur.y] + 1;
                        }
                    }
                }
            }
        }
        int x = dis[lake.x][lake.y] - 1;
        //System.out.println(x);
        bw.write(String.valueOf(x));
        bw.newLine();
        bw.flush();
        bw.close();

    }
    static class Pair {
        int x;
        int y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
