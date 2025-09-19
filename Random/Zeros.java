package Random;

import java.util.Scanner;

public class Zeros {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong() - 1, b = sc.nextLong();
        long count = 0;
        for (long i = 2; i <= b; i *= 2) {
            if (a / i != b / i) {
                count++;
            } else {break;}
        }
        long count2 = 0;
        for (long i = 5; i <= b; i *= 5) {
            if (a / i != b / i) {
                count2++;
            } else {break;}
        }
        System.out.println(Math.min(count, count2));
    }
}
