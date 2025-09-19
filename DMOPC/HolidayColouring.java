package DMOPC;

import java.util.Scanner;

public class HolidayColouring {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), m = sc.nextLong();
        long area = 0;
        if (n % 2 == 0 && n > m) {
            area = (long) (Math.ceil(n/2.0)) * m;
        } else if (m % 2 == 0 && m > n) {
            area = (long) Math.ceil(m/2.0) * n;
        } else if (n % 2 == 0) {
            area = (long) (Math.ceil(n/2.0)) * m;
        } else if (m % 2 == 0) {
            area = (long) (Math.ceil(m/2.0)) * n;
        } else if (n > m) {
            area = (long) (Math.ceil(n/2.0)) * m;
        } else {
            area = (long) (Math.ceil(m/2.0)) * n;
        }
        System.out.println(area + " " + ( n * m - area));
    }
}
