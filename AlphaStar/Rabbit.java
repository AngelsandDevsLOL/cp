package AlphaStar;

import java.util.Arrays;
import java.util.Scanner;

public class Rabbit {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n+2][2];
        ar[0][0] = Integer.MAX_VALUE; ar[1][0] = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 2; i < n + 2; i++) {
            String[] input = sc.nextLine().split(" ");
            ar[i][0] = Integer.parseInt(input[1]);
            if (input[0].equals("NS")) {
                ar[i][1] = 0;
            } else {
                ar[i][1] = 1;
                ans++;
            }
        }
        Arrays.sort(ar, (x, y) -> Integer.compare(x[0], y[0]));
        for (int i = 1; i < ar.length && ar[i - 1][0] <= b; i++) {
            if (ar[i][1] == ar[i - 1][1] && ar[i][1] == 0 || ar[i][0] <= a) continue;
            else if (ar[i][1] == 1 && ar[i - 1][1] == ar[i][1]) {
                ans += Math.min(ar[i][0], b) - Math.max(a, ar[i - 1][0]) - 1;
            } else if (ar[i][1] == 1 && ar[i - 1][1] == 0) {
                if ((ar[i][0] + ar[i - 1][0])% 2 == 0) {
                    ans += Math.min(ar[i][0], b) - Math.max((ar[i][0] + ar[i - 1][0]) / 2, a);
                } else {
                    ans += Math.min(ar[i][0], b) - Math.max(Math.ceil((ar[i][0] + ar[i - 1][0]) / 2.0), a);
                }
            } else {
                if ((ar[i][0] + ar[i - 1][0]) % 2 == 0) {
                    ans += Math.min((ar[i][0] + ar[i - 1][0]) / 2, b) - Math.max(ar[i - 1][0], a);
                } else {
                    ans += Math.min(Math.floor((ar[i][0] + ar[i - 1][0]) / 2.0), b) - Math.max(ar[i - 1][0], a);
                }
            }
        }
        System.out.println(ans);
    }
}
