package AlphaStar;

import java.util.Scanner;

public class PawEarTail {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            String x = sc.nextLine();
            if (x.equals("P")) ar[i][0]++;
            else if (x.equals("E")) ar[i][1]++;
            else ar[i][2]++;
            ar[i][0] += ar[i - 1][0]; ar[i][1] += ar[i - 1][1]; ar[i][2] += ar[i - 1][2];
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, ar[i][1] + (ar[n][2] - ar[i - 1][2])); // p up to this point, e for the rest
            max = Math.max(max, ar[i][1] + (ar[n][0] - ar[i - 1][0]));
            max = Math.max(max, ar[i][0] + (ar[n][2] - ar[i - 1][2])); // p up to this point, e for the rest
            max = Math.max(max, ar[i][0] + (ar[n][1] - ar[i - 1][1]));
            max = Math.max(max, ar[i][2] + (ar[n][1] - ar[i - 1][1])); // p up to this point, e for the rest
            max = Math.max(max, ar[i][2] + (ar[n][0] - ar[i - 1][0]));
        }
        System.out.println(max);
    }
}
