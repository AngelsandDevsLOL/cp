package YetAnotherContest;

import java.util.*;

public class NoMoreTelemarketers {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n+1];
        ArrayList<Integer>[] rank = new ArrayList[n+1];
        ArrayList<Integer>[] aList = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            aList[i] = new ArrayList<>();
            rank[i] = new ArrayList<>();
        }
        int ceo = 1;
        for (int i = 1; i <= n; i++) {
            parent[i] = sc.nextInt();
            if (parent[i] != -1) {
                aList[parent[i]].add(i);
            } else ceo = i;
        }
        int neo = 1;
        int[] want = new int[n+1];
        for (int i = 1; i <= n; i++) {
            want[i] = sc.nextInt();
            if (want[i] == -1) neo = i;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (want[i] != parent[i]) {
                count++;
            }
        }
        if (n == 2) {
            System.out.println(-1);
        } else {
            System.out.println(count);
            for (int i = 1; i <= n; i++) {
                if (want[i] != parent[i]) {
                    System.out.println(i + " " + want[i]);
                }
            }
        }
    }
}
