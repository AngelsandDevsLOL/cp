package LCC;

import java.util.*;

public class BeLeafIngInTheLeafs {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] scores = new int[n+1];
        ArrayList<Integer>[] aList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            scores[i] = scanner.nextInt();
            aList[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();
        int[] team = new int[k];
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            team[i] = scanner.nextInt();
            tMap.put(scores[team[i]], team[i]);
        }
        int co = 0;
        for (int i : tMap.keySet()) {
            team[co] = tMap.get(i); co++;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            aList[a].add(b);
            aList[b].add(a);
        }
        int[][] dis = new int[k][n+1];
        int c = 0;
        while (c != team.length) {
            q.add(team[c]);
            boolean[] vis = new boolean[n];
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i : aList[cur]) {
                    if (!vis[i-1]) {
                        q.add(i);
                        dis[c][i] = scores[i];
                        vis[i-1]= true;
                    }
                }
            }
            c++;
        }
        HashSet<Integer> hSet = new HashSet<>();
        long count = 0;
        for (int i = 0; i < k; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < n+1; j++) {
                if (dis[i][j] > max && !hSet.contains(j)) {
                    max = dis[i][j];
                    index = j;
                }
            }
            hSet.add(index);
            count = count + max;
        }
        System.out.println(count);
    }
}
