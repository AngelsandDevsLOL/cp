package CCC.MockJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class RGB {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String x = sc.nextLine();
        int[] b = new int[n];
        ArrayList<Integer> start = new ArrayList<>();
        TreeSet<Integer> g = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (x.charAt(i) == 'G') {
                g.add(i);
            } else if (x.charAt(i) == 'R') start.add(i);
            else if (x.charAt(i) == 'B') b[i]++;
            if (i > 0) b[i] += b[i - 1];
        }
        long count = 0;
        for (int i = 0; i < start.size(); i++) {
            if (g.ceiling(start.get(i)) == null) break;
            int firstG = g.ceiling(start.get(i));
            int end = n - 1;
            if (g.ceiling(firstG + 1) != null) {
                end = g.ceiling(firstG + 1);
            }
            count += b[end] - b[firstG];
        }
        System.out.println(count);
    }
}
