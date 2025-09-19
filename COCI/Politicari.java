package COCI;

import java.util.*;

public class Politicari {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] ar = new int[n][n]; // [getting blamed][blamer]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }
        HashMap<Pair, Integer> hMap = new HashMap<>();
        hMap.put(new Pair(1, 2), 1);
        int x = 1; // blamer
        int y = 2; // getting blamed
        int cycle = 1;
        int num = 0;
        while (true) {
            int temp = ar[y-1][x-1];
            x = y;
            y = temp;
            if (hMap.containsKey(new Pair(x, y))) {
                num = hMap.get(new Pair(x, y)) - 1;
                break;
            }
            hMap.put(new Pair(x, y), cycle + 1);
            cycle++;
        }
        if (k < num) {
            for (Pair p : hMap.keySet()) {
                if (hMap.get(p).equals(k)) System.out.println(p.x);
            }
        } else {
            k -= num;
            k = k % cycle;
            k+=num;
            if (k == 0) k = cycle;
            for (Pair p : hMap.keySet()) {
                if (hMap.get(p).equals(k)) System.out.println(p.x);
            }
        }
    }
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y =y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
