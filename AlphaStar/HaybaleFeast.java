package AlphaStar;

import java.util.*;

public class HaybaleFeast {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long m = sc.nextLong();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            int flavor = sc.nextInt(), spiciness = sc.nextInt();
            input[i][0] = flavor; input[i][1] = spiciness;
        }
        int ans = Integer.MAX_VALUE;
        long sum = input[0][0];
        int right = 0;
        TreeMap<Integer, Integer> tSet = new TreeMap<>();
        tSet.put(input[0][1], 1);
        for (int i = 0; i < n; i++) {
            while (sum < m && right < n - 1) {
                right++;
                sum += input[right][0];
                if (tSet.containsKey(input[right][1])) {
                    tSet.put(input[right][1], tSet.get(input[right][1]) + 1);
                } else {
                    tSet.put(input[right][1], 1);
                }
            }
            if (sum < m) break;
            ans = Math.min(ans, tSet.floorKey(Integer.MAX_VALUE));
            sum -= input[i][0];
            if (tSet.get(input[i][1]) == 1) tSet.remove(input[i][1]);
            else tSet.put(input[i][1], tSet.get(input[i][1]) - 1);
        }
        System.out.println(ans);
    }
}
