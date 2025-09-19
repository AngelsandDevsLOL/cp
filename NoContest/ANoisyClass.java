package NoContest;

import java.util.*;

public class ANoisyClass {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] in = new int[n+1];
        ArrayList<Integer>[] aList = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            aList[x].add(y);
            in[y]++;
        }
        ArrayList<Integer> store = new ArrayList<>();
        // topo search
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(aList[i]);
            if (in[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : aList[cur]) {
                in[i]--;
                if (in[i] == 0) q.add(i);
            }
            aList[cur] = new ArrayList<>();
            store.add(cur);
        }
        boolean bool = true;
        for (int i = 0; i < in.length; i++) {
            if (in[i] != 0) {
                bool = false;
                break;
            }
        }
        if (bool) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
}