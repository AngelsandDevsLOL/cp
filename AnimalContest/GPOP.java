package AnimalContest;

import java.util.Arrays;
import java.util.Scanner;

public class GPOP {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[][] ar = new int[q * 2][2];
        int max = 1;
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            ar[i * 2][0] = l; ar[i * 2][1] = 1;
            ar[i * 2 + 1][0] = r + 1; ar[i * 2 + 1][1] = -1;
            max = Math.max(max, r - l + 1);
        }
        System.out.println(max);
        Arrays.sort(ar, (x, y) -> (x[0] == y[0] ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0])));
        int cur = 1;
        int val = 1;
        int count = 0;
        int[] output = new int[n + 1];
        for (int i = 0; i < q * 2; i++) {
            if (count == 0) {
                for (; cur < ar[i][0]; cur++) {
                    output[cur] = val;
                }
            } else {
                for (; cur < ar[i][0]; cur++) {
                    output[cur] = val;
                    val = (val + 1) % (max + 1);
                    if (val == 0) val = 1;
                }
            }
            count += ar[i][1];
            if (count == 0) {
                if (val == 1) val = max;
                else val = val - 1;
            }
        }
        for (; cur <= n; cur++) {
            output[cur] = val;
        }
        for (int i = 1; i < n; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println(output[n]);
    }
}
