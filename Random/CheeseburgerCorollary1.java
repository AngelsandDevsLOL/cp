package Random;

import java.util.Scanner;

public class CheeseburgerCorollary1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int buns = a * 2 + b * 2;
            int meat = a + b * 2;
            if (buns >= c + 1 && meat >= c) {
                System.out.println("Case #" + (i + 1) + ": YES");
            } else {
                System.out.println("Case #" + (i + 1) + ": NO");
            }
        }
    }
}
