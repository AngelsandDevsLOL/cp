package WLMOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GingerbreadHouses {
    // array that stores the previous node, where parent[i] = j, when j -> i (during the last bfs)
    public static int[] parent;
    public static void main (String[] args) {
        // first take in stuff
        // for every test case thing
        // run bfs from random node, run bfs from farthest, run bfs from farthest
        // keep track of the parent for the farthest
        // backtrack using parent array
        // pointer, using the 2 distance arrays
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println(t);
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // number of nodes

            ArrayList<int[]>[] aList = new ArrayList[n + 1]; // edge [node, weight]
            parent = new int[n + 1];

            for (int j = 0; j <= n; j++) {
                aList[j] = new ArrayList<>();
            }

            for (int j = 0; j < n - 1; j++) {
                int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
                aList[a].add(new int[]{b, c});
                aList[b].add(new int[]{a, c});
            }
            int maxVal = bfs(1, aList, new int[n + 1]); // the index of the node with the maximum value from node 1
            int[] dis1 = new int[n + 1]; // distance array from node a
            int nextVal = bfs(maxVal, aList, dis1); // the ind of the node with the maximum value from node a
            // notice that you do not need to return dis1 because it is automatically updated in the bfs method
            int dif = dis1[nextVal]; // maximum distance

            // let a and b be the endpoints, being maxVal and nextVal respectively
            // backtracking starts
            int radius = dif;
            int center = nextVal;
            for (int j = nextVal; j != -1; j = parent[j]) {
                int a = dis1[j]; // distance to j from node a
                int b = dif - dis1[j]; // distance to j from node b
                if (Math.abs(a - b) < radius) {
                    radius = Math.abs(a - b);
                    center = j;
                }
            }
            System.out.println(center);
        }
    }
    public static int bfs (int start, ArrayList<int[]>[] edges, int[] dis) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        boolean[] vis = new boolean[edges.length];
        vis[start] = true;
        int max = 0;
        int ind = 0;
        parent[start] = -1;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int[] edge : edges[curNode]) {
                if (!vis[edge[0]]) {
                    vis[edge[0]] = true;
                    dis[edge[0]] = dis[curNode] + edge[1];
                    if (dis[edge[0]] > max) {
                        max = dis[edge[0]];
                        ind = edge[0];
                    }
                    q.add(edge[0]);

                    parent[edge[0]] = curNode; // will only happen once since the graph is a tree!
                }
            }
        }
        return ind;
    }
}
