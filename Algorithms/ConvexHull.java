package Algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ConvexHull {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt();
        int[][] point = new int[n][2];
        int px = 0, py = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            point[i][0] = x; point[i][1] = y;
            if (y < py) {
                py = y; px = x;
            }
        }
        int finalPx = px;
        int finalPy = py;
        Arrays.sort(point, (x, y) -> {
            double angle1 = sort(x, finalPx, finalPy);
            double angle2 = sort(y, finalPx, finalPy);
            if (angle2 > angle1) {
                return -1;
            } else if (angle2 < angle1) return 1;
            else {
                if (angle1 < 90) { // quad 1, we want shorter to farther
                    return Integer.compare(x[0], y[0]);
                } else return Integer.compare(y[0], x[0]); // quad 2, we want farther to shorter
            }
        });
        System.out.println(ccw(11, 8, 9, 5, 7, 9));
        Stack<Integer> stack = new Stack<>();
        stack.add(n - 1); // original, that we KNOW is in there
        stack.add(0); // smallest polar angle ! (I think)
        int prev = n - 1; int cur = 0;
        for (int i = 1; i < n - 1; i++) {
            int next = i;
            while (!ccw(point[prev][0], point[prev][1], point[cur][0], point[cur][1], point[next][0], point[next][1])) {
                stack.pop();
                cur = prev; stack.pop();
                prev = stack.peek();
                stack.push(cur);
            }
            stack.push(next);
            prev = cur;
            cur = i;
        }
        prev = stack.pop();
        double ans = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            ans += Math.sqrt(Math.pow(point[prev][1] - point[cur][1], 2) + Math.pow(point[cur][0] - point[prev][0], 2));
        }
        System.out.println(ans);
    }
    public static boolean ccw (int x1, int y1, int x2, int y2, int x3, int y3) {
        int clockwise = ((y2 - y1) * (x3 - x2)) - ((x2 - x1) * (y3 - y2));
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3);
        System.out.println(clockwise);
        if (clockwise < 0) return true; // counterclockwise !
        return false;
    }
    public static double sort (int[] x, int px, int py) {
        if (x[1] == py) {
            return 180;
        }
        double changeY = x[1] - py;
        double changeX = x[0] - px;
        return Math.toDegrees(Math.atan2(changeY, changeX));
    }
}
