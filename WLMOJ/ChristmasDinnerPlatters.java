package WLMOJ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ChristmasDinnerPlatters {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        TreeSet<Integer>[] tSet = new TreeSet[(int) 1e6 + 1];
        for (int i = 0; i < tSet.length; i++) {
            tSet[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            tSet[x].add(i);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int index = (int) 1e6;
            for (int j = 0; j < x && index != -1; j++) {
                int num = sc.nextInt();
                if (tSet[num].floor(index - 1) == null) {
                    index = -1;
                }else {
                    index = tSet[num].floor(index - 1);
                }
            }
            if (index != -1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
