package COCI;

import java.util.*;

public class MovingDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> graph = new HashMap<>();
        HashMap<Integer, Integer> reverse = new HashMap<>();
        HashMap<Integer, String> names = new HashMap<>(); // current names of the owners of the house
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int from = Integer.parseInt(input[1]);
            int to = Integer.parseInt(input[2]);
            graph.put(from, to);
            reverse.put(to, from);
            names.put(from, input[0]);
        }
        boolean[] vis = new boolean[101];
        for (int x : graph.keySet()) {
            if (!vis[x]) {
                if (recursion(x, vis, graph)) {
                    System.out.println("Impossible");
                    return;
                }
            }
        }
        for (int x : reverse.keySet()) {
            if (!graph.containsKey(x)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(x);
                while (!queue.isEmpty()) {
                    int num = queue.poll();
                    if (reverse.containsKey(num)) {
                        vis[num] = true;
                        num = reverse.get(num);
                        System.out.println(names.get(num));
                        queue.add(num);
                    }
                }
            }
        }
    }

    public static boolean recursion(int x, boolean[] vis, HashMap<Integer, Integer> graph) {
        if (graph.containsKey(x)) {
            x = graph.get(x);
            if (!vis[x]) {
                vis[x] = true;
                boolean result = recursion(x, vis, graph);
                vis[x] = false;
                if (result) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}