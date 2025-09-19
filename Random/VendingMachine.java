package Random;

import java.util.Scanner;

public class VendingMachine {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long money = sc.nextLong();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), d = sc.nextLong();
            long x = money / (a + c) * (b + d);
            money %= (a + c);
            if (b > d && money >= a) {x += b;}
            else if (b > d && money >= c) {x += d;}
            else if (d > b && money >= c) {x += d;}
            else if (d > b && money >= a) {x += b;}
            System.out.println(x);
        }
    }
}
