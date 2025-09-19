package Random;

import java.util.Scanner;

public class WOSSGeeseAttack {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int cur = 0; // current time
        int lRangel = 0; int lRanger = 0;
        int rRangel = n + 1; int rRanger = n;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), t = sc.nextInt();
            long dis = (t - cur) * k;
            if (i == 0) {
                lRanger = (int) Math.min(dis, n);
            } else {
                if (lRangel <= lRanger) {
                    lRanger = (int) Math.max(lRanger + dis, n);
                    lRangel = (int) Math.min(lRangel - dis, 0);
                }
                if (rRangel <= rRanger) {
                    rRanger = (int) Math.max(rRanger + dis, n);
                    rRangel = (int) Math.min(rRangel - dis, 0);
                }
            }
            if (lRangel <= lRanger) {

            }
            if (lRangel > lRanger && rRangel > rRanger) {
                // doesn't work!
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
