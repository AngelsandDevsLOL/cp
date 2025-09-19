package SAC;

import java.util.ArrayList;
import java.util.Scanner;

public class ObligatoryTriangle {
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
            else angle = Math.toDegrees(Math.atan(Math.abs(y)/Math.abs(x)));
            if (x <= 0 && y < 0) {
                angle += 180;
            } else if (x < 0 && y > 0) {
                angle = 180 - angle;
            } else if (x > 0 && y < 0) {
                angle = 360 - angle;
            }
            double dif = Math.min(360 - Math.abs(angle - a), Math.abs(a - angle));
            if (i == 1 || closest > dif) {
                closest = dif;
                num = i;
            }
            //System.out.println(angle);
        }
        System.out.println(num);
    }
}
