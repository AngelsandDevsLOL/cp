package CCC.Junior;

import java.util.*;

public class ItsToughBeingATeen {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] in = new int[8];
        ArrayList<Integer>[] aList = new ArrayList[8];
        for (int i = 0; i < 8; i++) {
            aList[i] = new ArrayList<>();
        }
        aList[1].add(7);
        in[7]++;
        aList[1].add(4);
        in[4]++;
        aList[2].add(1);
        in[1]++;
        aList[3].add(4);
        in[4]++;
        aList[3].add(5);
        in[5]++; // those who don't have in: 2 3 6
        while (x != 0 && y != 0) {
            aList[x].add(y);
            in[y]++;
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        ArrayList<Integer> store = new ArrayList<>();
        // topo search
        Stack<Integer> q = new Stack<>();
        for (int i = 1; i < 8; i++) {
            Collections.sort(aList[i]);
            if (in[i] == 0) q.push(i);
        }
        while (!q.isEmpty()) {
            int cur = q.pop();
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
