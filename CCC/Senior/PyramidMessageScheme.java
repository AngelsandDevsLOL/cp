package CCC.Senior;

import java.util.*;

public class PyramidMessageScheme {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        for (int i = 0; i < l; i++) {
            int x = scanner.nextInt();
            ArrayList<Integer>[] aList = new ArrayList[x];
            HashMap<String, Integer> hMap = new HashMap<>();
            for (int j = 0; j < x; j++) {
                aList[j] = new ArrayList<>();
            }
            int count = 0;
            scanner.nextLine();
            for (int j = 0; j < x / 2; j++) {
                String a = scanner.nextLine();
                String b = scanner.nextLine();
                int c;
                int d;
                if (hMap.containsKey(a)) {
                    c = hMap.get(a);
                } else {
                    c = count;
                    hMap.put(a, count);
                    count++;
                }
                if (hMap.containsKey(b)) {
                    d = hMap.get(b);
                } else {
                    d = count;
                    hMap.put(b, count);
                    count++;
                }
                aList[c].add(d);
                aList[d].add(c);
            }
            Queue<Integer> q = new LinkedList<>();
            int find = hMap.get("Home");
            boolean[] vis = new boolean[x];
            int[] dis = new int[x];
            vis[find] = true;
            q.add(find);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j : aList[cur]) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.add(j);
                        dis[j] = dis[cur] + 1;
                    }
                }
            }
            Arrays.sort(dis);
            System.out.println((x - (dis[dis.length-1]) * 2) * 10);
        }
    }
}
