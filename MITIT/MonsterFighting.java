package MITIT;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class MonsterFighting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            TreeMap<Integer, Integer>[] input = new TreeMap[2];
            input[0] = new TreeMap<>(); input[1] = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt(), y = sc.nextInt();
                if (input[y].containsKey(x)) {
                    input[y].put(x, input[y].get(x) + 1);
                } else input[y].put(x, 1);
            }
            int[][] query = new int[n][2];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt(), y = sc.nextInt();
                query[j][0] = x; query[j][1] = y;
            }
            Arrays.sort(query, (x, y) -> Integer.compare(y[0], x[0]));
            boolean works = true;
            for (int j = 0; j < n; j++) {
                int x = query[j][0]; int y = query[j][1];
                if (input[y].ceilingKey((x + 1) / 2) != null) {
                    int ind = input[y].ceilingKey((x + 1) / 2);
                    int val = input[y].get(ind);
                    if (val == 1) input[y].remove(ind);
                    else input[y].put(ind, val - 1);
                } else if (input[1 - y].ceilingKey(x) != null) {
                    int temp = 1 - y;
                    int ind = input[temp].ceilingKey(x);
                    int val = input[temp].get(ind);
                    if (val == 1) input[temp].remove(ind);
                    else input[temp].put(ind, val - 1);
                } else {
                    works = false; break;
                }
            }
            if (!works) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
