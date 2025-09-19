package AlphaStar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class FairPhotography {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] cows = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            cows[i][0] = Integer.parseInt(input[0]);
            cows[i][1] = input[1].equals("W") ? 1 : -1;
        }
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, cows[0][0]);

        int ans = -1;
        int preSum = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] cow = cows[i];
            preSum += cow[1];

            int x = preSum;
            if (preSum >= 0) {
                x = preSum % 2;
                if (firstSeen.containsKey(x)) {
                    ans = Math.max(ans, cow[0] - firstSeen.get(x));
                }
                if (firstSeen.containsKey(-x)) {
                    ans = Math.max(ans, cow[0] - firstSeen.get(-x));
                }
                if (!firstSeen.containsKey(preSum)) {
                    firstSeen.put(preSum, cows[i + 1][0]);
                }
            }
        }
        System.out.println(ans);
    }
}
