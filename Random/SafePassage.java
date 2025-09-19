package Random;

import java.util.Arrays;
import java.util.Scanner;

public class SafePassage {
    static int max = Integer.MAX_VALUE;
    static int n;
    static int[] ar;
    static int[] times;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ar = new int[(int) (Math.pow(2, n))];
        times = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            times[i] = x;
        }
        recursion(0, 0, true);
        System.out.println(ar[(int) (Math.pow(2, n) - 1)]);
    }
    // location == true = we currently have the invisible thing
    // x = how many people are on the other side
    public static void recursion(int x, int time, boolean location) {
        if (location) {
            for (int i = n - 2; i >= 0; i--) { // person 1
                if ((x & (1 << i)) == 0) {
                    for (int j = n - 1; j >= i + 1; j--) { // person 2
                        if ((x & (1 << j)) == 0) {
                            // goodbye
                            x = x | (1 << i);
                            x = x | (1 << j);
                            recursion(x, time + Math.max(times[n - i - 1], times[n - j - 1]), false);
                            x = x & ~ (1 << i);
                            x = x & ~ (1 << j);
                        }
                    }
                }
            }
        } else {
            if (ar[x] == 0 || ar[x] > time) {
                ar[x] = time;
                if (x == (int) (Math.pow(2, n) - 1)) return;
                for (int i = 0; i < n; i++) {
                    if (((x & (1 << i)) == 1 << i)) {
                        recursion(x & ~ (1 << i), time + times[n - i - 1], true);
                        x = x | (1 << i);
                    }
                }
            }
        }
    }
}
