package SAC;

import java.io.*;
import java.util.*;

public class CourseRequirements {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] in = new int[n+1];
        ArrayList<Integer>[] aList = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                int y = scanner.nextInt();
                aList[i].add(y);
                in[y]++;
            }
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
        for (int i = 0; i < store.size(); i++) {
            System.out.print(store.get(i) +" ");
        }
    }
}