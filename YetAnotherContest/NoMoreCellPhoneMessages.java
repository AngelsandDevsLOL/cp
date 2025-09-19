package YetAnotherContest;

import java.util.Scanner;

public class NoMoreCellPhoneMessages {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        System.out.println("? " + n + " " + m);
        System.out.flush();
        int p1 = (sc.nextInt() - n - m) * -1; // sum of coords
        System.out.flush();
        System.out.println("? 1 1");
        System.out.flush();
        int p2 = sc.nextInt() + 2; // sum of other coords
        System.out.flush();
        System.out.println("? 1 " + m);
        System.out.flush();
        int p3 = sc.nextInt() - m + 1; //
        System.out.flush();
        System.out.println("? " + n + " 1");
        System.out.flush();
        int p4 = (sc.nextInt() - n + 1) * -1;
        System.out.flush();
        if (((p1 + p3) / 2) %2 == 0 && (p1 + p3) / 2 <= n && p1 - (p1 + p3) / 2 <= m) {
            int x = (p1 + p3) / 2;
            System.out.println("? " + x + " " + (p1 - x));
            System.out.flush();
            int input = sc.nextInt();
            System.out.flush();
            if (input != 0) {
                x = (p1 + p4) / 2;
                int x2 = (p2 + p3) / 2;
                System.out.println("! " + x + " " + (p1 - x) + " " + x2 + " " + (p2 - x2));
                System.out.flush();
            } else {
                int x2 = (p2 + p4) / 2;
                System.out.println("! " + x + " " + (p1 - x) + " " + x2 + " " + (p2 - x2));
                System.out.flush();
            }
        } else {
            int x = (p1 + p4) / 2;
            System.out.println("? " + x + " " + (p1 - x));
            System.out.flush();
            int input = sc.nextInt();
            System.out.flush();
            if (input != 0) {
                x = (p1 + p3) / 2;
                int x2 = (p2 + p4) / 2;
                System.out.println("! " + x + " " + (p1 - x) + " " + x2 + " " + (p2 - x2));
                System.out.flush();
            } else {
                int x2 = (p2 + p3) / 2;
                System.out.println("! " + x + " " + (p1 - x) + " " + x2 + " " + (p2 - x2));
                System.out.flush();
            }
        }
    }
}
