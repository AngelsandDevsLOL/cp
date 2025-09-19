package YetAnotherContest;

import java.util.Scanner;
// uhh not actually here just forgot where it is- countlesscalculatorcomputations
public class Main   {
    static double eps = 1e-6;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = q; i > 0; i--) {
            long y = scanner.nextLong();
            long z = scanner.nextLong();
            double lo = 1.0;
            double hi = Math.sqrt(z);
            while (hi - lo >= eps) {
                double m = (lo + hi) / 2;
                if (check(m, y, z)) hi = m;
                else lo = m;
            }
            System.out.println(lo);
        }
    }
    static boolean check (double x, long y, long z) {
        double pw = 1.0;
        for (int i = 1; i <= y; i++) {
            pw = Math.pow(x, pw);
            if (pw -z >= eps) return true;
        }
        return false;
    }
}
