package WC;

import java.util.*;

public class AttackOfTheClones {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         // x = 1, increasing order
        // Arrays.sort(input, (x, y) -> (x[0] == y[0] ? Integer.compare(x[1], y[1]) * (x[0] % 2 == 1 ? 1 : -1) : Integer.compare(x[0], y[0])));
        TreeMap<Integer, int[]> tMap = new TreeMap<>();
        long ans = 0;
        tMap.put(1, new int[]{1, 1});
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt() * (x % 2 == 1 ? 1 : -1);
            int leftX = -1, leftY = -1;
            int rightX = -1, rightY = -1;
            if (tMap.containsKey(x)) {
                int[] num = tMap.get(x);

                if (num[0] > y) {
                    rightX = x; rightY = num[0];
                    num[0] = y;
                } else if (num[1] > y) {
                    rightX = x; rightY = num[1];
                }

                if (num[1] < y) {
                    leftX = x; leftY = num[1];
                    num[1] = y;
                } else if (num[0] < y) {
                    leftX = x; leftY = num[0];
                }
            } else {
                tMap.put(x, new int[]{y, y});
            }
            if (leftX == -1 && tMap.lowerKey(x) != null) {
                leftX = tMap.lowerKey(x);
                leftY = tMap.get(leftX)[1];
            }
            if (rightX == -1 && tMap.higherKey(x) != null) {
                rightX = tMap.higherKey(x);
                rightY = tMap.get(rightX)[0];
            }
            if (leftY < 0) leftY *= -1;
            if (y < 0) y *= -1;
            if (rightX == -1) {
                ans += Math.abs(x - leftX) + Math.abs(y - leftY);
            } else {
                if (rightY < 0) rightY *= -1;
                ans -= Math.abs(rightY - leftY) + Math.abs(leftX - rightX);
                ans += Math.abs(x - leftX) + Math.abs(y - leftY) + Math.abs(x - rightX) + Math.abs(y - rightY);
            }
            System.out.println(ans);
        }
    }
}
