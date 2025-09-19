package OTH;

import java.util.Scanner;

public class The5thLaboratory {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        int n = sc.nextInt();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int xx = sc.nextInt() - x, yy = sc.nextInt() - y, zz = sc.nextInt() - z;
            double a = 1.0 * xx * xx + yy * yy;
            if (zz == 0) {
                min = Math.min(min, Math.sqrt(a) / 2);
            } else if (zz < 0) {
                min = Math.min(min, Math.sqrt(a) / 2 - zz);
            } else {
                double ans = zz / 4.0;
                double distance = Math.sqrt(a) - Math.min(ans * 3, Math.sqrt(a));
                min = Math.min(min, ans + distance / 2);
            }
        }
        System.out.println(min);
    }
}
