package AlphaStar;

import CCC.ScramblingSwaps;

import java.util.*;

public class SquareOverlap {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt() / 2;
        int[][] ar = new int[n][2];
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            ar[i][0] = x;
            ar[i][1] = y;
            tSet.add(ar[i][0] + k + 1); tSet.add(ar[i][1] - k + 1);
            tSet.add(ar[i][0] - k + 1); tSet.add(ar[i][1] + k + 1);
        }
        int counter = 1;
        HashMap<Integer, Integer> hMap1 = new HashMap();
        HashMap<Integer, Integer> hMap2 = new HashMap<>();
        for (int x : tSet) {
            hMap2.put(x, counter);
            hMap1.put(counter++, x);
        }
        int[][] psa = new int[counter][counter];
        for (int i = 0; i < n; i++) {
            psa[hMap2.get(ar[i][0] - k + 1)][hMap2.get(ar[i][1] - k + 1)]++;
            psa[hMap2.get(ar[i][0] + k + 1)][hMap2.get(ar[i][1] + k + 1)]++;
            psa[hMap2.get(ar[i][0] - k + 1)][hMap2.get(ar[i][1] + k + 1)]--;
            psa[hMap2.get(ar[i][0] + k + 1)][hMap2.get(ar[i][1] - k + 1)]--;
        }
        int sum = 0;
        for (int i = 1; i < counter && sum != -1; i++) {
            for (int j = 1; j < counter; j++) {
                psa[i][j] += psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1];
                if (psa[i][j] > 2) {sum = -1; break;}
                if (psa[i][j] == 2 && sum != 0 && !(psa[i - 1][j] == 2 || psa[i][j - 1] == 2)) {sum = -1; break;}
                if (psa[i][j] == 2) {
                    sum += (hMap1.get(i + 1) - hMap1.get(i)) * (hMap1.get(j + 1) - hMap1.get(j));
                }
            }
        }
        System.out.println(sum);
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
