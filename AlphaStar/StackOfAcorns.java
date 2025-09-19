package AlphaStar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class StackOfAcorns {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] ar = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            ar[i] = new Pair(x, y);
        }
        Arrays.sort(ar);
        int ans = 1;
        for (int i = 0; i < 1 << (n + 1); i++) {
            int sum = 0;
            int prevy = 0;
            int prevx = 0;
            boolean works = true;
            for (int j = 0; j < n; j++) {
                if ((i | (1 << j)) == i) { // 1
                    if (ar[j].y <= prevy || ar[j].x == prevx) {works = false;break;}
                    prevx = ar[j].x;
                    prevy = ar[j].y;
                    sum++;
                }
            }
            if (works) ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
        public static class Pair implements Comparable {
        int x;
        int y;
        public Pair (int xx, int yy) {x = xx; y = yy;}

        @Override
        public int compareTo(Object o) {
            if (x == ((Pair)o).x) {
                return Integer.compare(y, ((Pair)o).y);
            }
            return Integer.compare(x, ((Pair)o).x);
        }
    }
}
