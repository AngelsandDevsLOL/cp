package Random;

import java.util.Scanner;

public class BasesMultiplication {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int firstNum = sc.nextInt();
            int firstBase = sc.nextInt();
            int secondNum = sc.nextInt();
            int secondBase = sc.nextInt();
            int newBase = sc.nextInt();
            System.out.println(toNewBase(toBase10(firstNum, firstBase) * toBase10(secondNum, secondBase), newBase));
        }
    }
    public static int toBase10 (int num, int base) {
        int sum = 0;
        int count = 0;
        while (num != 0) {
            sum += (num % 10 * Math.pow(base, count));
            num /= 10;
            count++;
        }
        return sum;
    }
    public static String toNewBase (int num, int base) { // from base 10
        StringBuilder str = new StringBuilder();
        while (num != 0) {
            str.insert(0, (num % base));
            num /= base;
        }
        return str.toString();
    }
}
