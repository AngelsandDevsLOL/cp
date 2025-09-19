package USACO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FeedingTheCows {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Integer> h = new ArrayList<>();
            ArrayList<Integer> g = new ArrayList<>();
            String input = scanner.nextLine();
            Stack<Integer> x = new Stack();
            for (int j = 0; j < k; j++) {
                x.add(j);
            }
            for (int j = 0; j < n; j++) {
                if (j + k<= n -1) {
                    x.push(j+k);
                }
                if (input.charAt(j) == 'H') {
                    if (!h.isEmpty() && (Math.abs(j - h.get(h.size() - 1)) <= k)) {
                    } else {
                        h.add(x.pop());
                    }
                } else {
                    if (!g.isEmpty() && Math.abs(j - g.get(g.size() - 1)) <= k) {
                    } else {
                        g.add(x.pop());
                    }
                }
            }
            System.out.println(n - x.size());
            int p1 = 0, p2 = 0;
            for (int j = 0; j < n; j++) {
                if (p1 < h.size() && h.get(p1) == j) {
                    System.out.print("H");
                    p1++;
                } else if (p2 < g.size() && g.get(p2) == j) {
                    System.out.print("G");
                    p2++;
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
