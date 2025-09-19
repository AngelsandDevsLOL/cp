package Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CanShahirEvenGetThere {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ArrayList[] aList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            aList[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            aList[x].add(y);
            aList[y].add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            ArrayList<Integer> aL = aList[current];
            for (int i = 0; i < aL.size(); i++) {
                if (!visited[aL.get(i)]) {
                    visited[aL.get(i)] = true;
                    q.add(aL.get(i));
                }
            }
        }
        if (visited[b]) {
            System.out.println("GO SHAHIR!");
        } else {
            System.out.println("NO SHAHIR!");
        }
    }
}
