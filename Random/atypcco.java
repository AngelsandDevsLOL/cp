package Random;

import java.util.Scanner;

public class atypcco {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong(), k = sc.nextInt();
        if (m % 2 == 0){
            System.out.println(m / 2 * 3);
            System.out.println((int)Math.pow(2, m / 2));
        } else {
            if (m == 1) {
                System.out.println(3);
                System.out.println(1);
            } else {
                System.out.println(m / 2 * 3 + 3);
                System.out.println((int)Math.pow(2, m / 2) * (m / 2 + 1));
            }
        }
    }
}
