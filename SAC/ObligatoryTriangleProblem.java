package SAC;

import java.util.Scanner;

public class ObligatoryTriangleProblem {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt();
        int num = 1;
        double closest = a;
        for (int i = 1; i <= n; i++) {
            double x = sc.nextInt(), y = sc.nextInt();
            double angle;
            if (y == 0 && x < 0) {
                angle = 180;
            } else if (y == 0 && x > 0) angle = 0;
            else if (x == 0 && y < 0) angle = 270;
            else angle = Math.toDegrees(Math.atan(y/x));
            if (x < 0 && y < 0) angle += 180;
            double dif = Math.min(Math.abs(angle - a), Math.abs(a - angle - 360));
            if (i == 1 || closest > dif) {
                closest = dif;
                num = i;
            }
            System.out.println(angle);
        }
        //System.out.println(num);
    }
}
