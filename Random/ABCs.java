package Random;

import java.util.Scanner;

public class ABCs {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int a1 = sc.nextInt(), a2 = sc.nextInt(), a3 = sc.nextInt();
        int b1 = sc.nextInt(), b2 = sc.nextInt(), b3 = sc.nextInt();
        int c1 = sc.nextInt(), c2 = sc.nextInt(), c3 = sc.nextInt();
        if (a1 == b2 && c2 > 0) {
            count += c2;
        }
        if (a2 == b3 && c3 > 0) {
            count += c3;
        }
        if (a3 == b1 && c1 > 0) {
            count += c1;
        }
        System.out.println(count);

    }
}
