package LCC;

import java.util.Scanner;

public class UnbeLeafAbleSchedules {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int[] x = new int[n+2];
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b  = scanner.nextInt();
            x[a]++;
            x[b+1]--;
        }
        boolean bool = true;
        int highest = 0;
        for (int i = 1; i < n+2; i++) {
            x[i] = x[i] + x[i-1];
            if (x[i] > m) {
                bool = false;
                break;
            }
            highest = Math.max(highest, x[i]);
        }
        if (bool) System.out.println(highest);
        else System.out.println("TAKE A BREAK JAMES");
    }
}
