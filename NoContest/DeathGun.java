package NoContest;

import java.util.*;

public class DeathGun {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, Integer> hMap = new HashMap<>();
        ArrayList<String>[] aList = new ArrayList[m * 2];
        int[] in = new int[m * 2];
        int count = 0;
        for (int i = 0; i < m * 2; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            String a = input[0];
            String b = input[1];
            if (!hMap.containsKey(a)) {
                hMap.put(a, count++);
            }
            if (!hMap.containsKey(b)) {
                hMap.put(b, count++);
            }
            aList[hMap.get(b)].add(a);
            in[hMap.get(a)]++;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for (String x : hMap.keySet()) {
            if (in[hMap.get(x)] == 0) q.add(new Pair(hMap.get(x), x));
        }
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            System.out.println(cur.node);
            for (String i : aList[hMap.get(cur.node)]) {
                in[hMap.get(i)]--;
                if (in[hMap.get(i)] == 0) {
                    q.add(new Pair(hMap.get(i), i));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int out;
        String node;

        public Pair(int out, String node) {
            this.out = out;
            this.node = node;
        }
        @Override
        public int compareTo(Pair o) {
            return 0;
        }
    } // int in, String node

}
