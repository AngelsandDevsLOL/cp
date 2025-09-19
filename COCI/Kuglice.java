package COCI;

import java.util.*;

public class Kuglice {
    public static int[] parent;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] graph = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            graph[i] = a;
            parent[i] = i;
        }
        int q = sc.nextInt();
        int[][] input = new int[q][2];
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt(), x = sc.nextInt();
            input[i][0] = query;
            input[i][1] = x;
            if (query == 2) graph[x] = -graph[x];
        }
        boolean[] done = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!done[i]) {
                if (graph[i] > 0) {
                    int p = par(i);
                    int next = par(graph[i]);
                    if (p == next) {
                        parent[p] = -1;
                    } else parent[p] = next;
                }
                done[i] = true;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = q - 1; i >= 0; i--) {
            if (input[i][0] == 1) { // print
                int p = par(input[i][1]);
                stack.push(p);
            } else {
                // introduce a new edge !
                graph[input[i][1]] = -graph[input[i][1]];
                int p1 = input[i][1];
                int p2 = par(graph[input[i][1]]);
                if (p1 == p2) {
                    parent[p1] = -1;
                } else {
                    parent[p1] = p2;
                }
            }
        }
        while (!stack.isEmpty()) {
            int output = stack.pop();
            if (output == -1) System.out.println("CIKLUS");
            else System.out.println(output);
        }
    }
    public static int par (int x) {
        if (parent[x] == x) return x;
        else if (parent[x] == -1) return -1;
        return parent[x] = par(parent[x]);
    }
}
