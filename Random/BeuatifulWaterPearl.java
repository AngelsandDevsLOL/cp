package Random;

import java.util.Scanner;

public class BeuatifulWaterPearl {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(), d = sc.nextInt(), e = sc.nextInt();
        int num = Math.max(d, e);
        int bits = (int) Math.ceil(Math.log(num) / Math.log(2));
        long count = 0;
        for (int i = 0; i < bits; i++) {
            if ((d >> i & 1) == 0 && (c >> i & 1) == 1 && (e >> i & 1) == 1) {
                count++;
            }
        }
        System.out.println((int)Math.pow(2, count));
    }
}
