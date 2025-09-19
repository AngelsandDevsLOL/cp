package AlphaStar;

import java.util.*;

public class SnowBoots {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] ar = new int[n];
        TreeMap<Integer, ArrayList<Integer>> tMap = new TreeMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int depth = sc.nextInt();
            ar[i] = depth;
            if (tMap.containsKey(depth)) {
                tMap.get(depth).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                tMap.put(depth, aList);
            }
        }
        int[][] output = new int[n][3];
        for (int i = 0; i < q; i++) {
            int depth = sc.nextInt(), step = sc.nextInt();
            output[i][0] = depth; output[i][1] = step; output[i][2] = i;
        }
        Arrays.sort(output, (x, y) -> Integer.compare(x[0], y[0]));
        TreeSet<Integer> indexes = new TreeSet<>();
        int ans = n - 1;
        indexes.add(0); indexes.add(n - 1);
        for (int i = 0; i < n; i++) {

        }
    }
}
