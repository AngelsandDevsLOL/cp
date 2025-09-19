package USACO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MilkVisits {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer>[] aList = new ArrayList[n + 1  ];
        String input = sc.nextLine();
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            aList[x].add(y);
            aList[y].add(x);
        }
        boolean[] vis = new boolean[n + 1];
        int count = 0;

        Queue<Integer>[] q = new Queue[3];
    }
}
