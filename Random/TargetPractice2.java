package Random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TargetPractice2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), x1 = sc.nextInt();
            int[] slope = new int[4 * n];
            int[] x1y = new int[2 * n];
            Queue<Integer> qtop = new LinkedList<>();
            Queue<Integer> qbot = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                int y2 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt();
                x1y[j * 2] = y1;
                x1y[j * 2 + 1] = y2;
                qtop.add(x2);
                qtop.add(y2);
                qbot.add(x2);
                qbot.add(y1);
            }
            Arrays.sort(x1y);
            for (int j = 0; j < 4 * n; j++) {
                slope[j] = sc.nextInt();
            }
            Arrays.sort(slope);
            int b = bsearch(1, 4 * n, 0, slope); // num of negative
            if (b >= n && b <= 3 * n) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                // the excess bit
                for (int j = 0; j < b - n; j++) { // number of negative slopes
                    int yint = x1y[j] - slope[j] * x1;
                    max = Math.max(max, yint);
                    min = Math.min(min, yint);
                }
                for (int j = 0; j < 4 * n - b - n; j++) { // number of positive slopes
                    int yint = x1y[2 * n - j - 1] - slope[4 * n - 1 - j] * x1;
                    max = Math.max(max, yint);
                    min = Math.min(min, yint);
                }
                // slope from b - n to (4 * n - (a - n)), where a is 4 * n - b
                // from b - n to 4 * n - 3 * n + b) = n + b
                // 0 is b
                for (int j = b - n; j < b; j++) { // still negative slope
                    int slopeval = slope[j];
                    int lowesty = Integer.MAX_VALUE;
                    int bestx = Integer.MAX_VALUE, besty = Integer.MAX_VALUE;
                    for (int k = 0; k < qbot.size(); k++) {
                        int x = qbot.poll(), y = qbot.poll();
                        int num = y - slopeval * x;
                        if (num < lowesty) {
                            lowesty = num;
                            if (bestx != Integer.MAX_VALUE) {
                                qbot.add(bestx);
                                qbot.add(besty);
                            }
                            bestx = x; besty = y;
                        } else {
                            qbot.add(x); qbot.add(y);
                        }
                    }
                    max = Math.max(max, lowesty);
                    min = Math.min(min, lowesty);
                }
                for (int j = n + b - 1; j >= b; j--) {
                    int slopeval = slope[j];
                    int highesty = Integer.MIN_VALUE;
                    int bestx = Integer.MIN_VALUE, besty = Integer.MIN_VALUE;
                    for (int k = 0; k < qtop.size(); k++) {
                        int x = qtop.poll(), y = qtop.poll();
                        int num = y - slopeval * x;
                        if (num > highesty) {
                            highesty = num;
                            if (bestx != Integer.MIN_VALUE) {
                                qtop.add(bestx);
                                qtop.add(besty);
                            }
                            bestx = x; besty = y;
                        } else {
                            qtop.add(x); qtop.add(y);
                        }
                    }
                    max = Math.max(max, highesty);
                    min = Math.min(min, highesty);
                }
                System.out.println(max - min);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static int bsearch (int low, int high, int find, int[] ar) {
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ar[mid - 1] < find) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

}
