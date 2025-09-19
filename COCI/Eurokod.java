package COCI;

import java.util.*;

public class Eurokod {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, ArrayList<int[]>> tMap = new TreeMap<>();
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[sc.nextInt() - 1] = n - i;
        }
        TreeMap<Integer, Integer> members = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            members.put(sc.nextInt(), i);
        }
        int rank = 1;
        for (int x : members.keySet()) {
            if (tMap.containsKey(-(rank + sum[members.get(x)]))) {
                tMap.get(-(rank + sum[members.get(x)])).add(new int[]{-rank, members.get(x)});
            } else {
                ArrayList<int[]> aList = new ArrayList<>();
                aList.add(new int[]{-rank, members.get(x)});
                tMap.put(-(rank + sum[members.get(x)]), aList);
            }
            rank++;
        }
        int count = 1;
        for (int key : tMap.keySet()) {
            Collections.sort(tMap.get(key), (x, y) -> Integer.compare(x[0], y[0]));
            for (int[] p : tMap.get(key)) {
                System.out.println((count++) + ". Kod" + method(p[1]) + " (" + -key + ")");
            }
        }
    }
    public static String method (int x) {
        if (x >= 9) return String.valueOf(x + 1);
        else return "0" + String.valueOf(x + 1);
    }
    public static class Pair {
        int x;
        int y;
        public Pair (int xx, int yy) {
            x = xx; y = yy;
        }
    }
}
