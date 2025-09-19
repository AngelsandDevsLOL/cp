package CCC.Senior;

import java.util.Scanner;

public class MouseMove {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x != 0 || y != 0) {
            int curx = sc.nextInt(), cury = sc.nextInt();
            do {
                if (x > c) {
                    x = c;
                } else if (x < 0) {
                    x = 0;
                }
                if (y > r) {
                    y = r;
                } else if (y < 0) {
                    y = 0;
                }
                System.out.println(x + " " + y);
                x += curx;
                y += cury;
                curx = sc.nextInt();
                cury = sc.nextInt();
            } while (curx != 0 || cury != 0);


            if (x > c) {
                x = c;
            } else if (x < 0) {
                x = 0;
            }
            if (y > r) {
                y = r;
            } else if (y < 0) {
                y = 0;
            }
            System.out.println(x + " " + y);
        } else {

        }
    }
}
