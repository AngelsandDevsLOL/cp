package CCC;

import java.util.Scanner;

public class Epidemiology {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int count = 0;
        int last = n;
        while (n <= p) {
            last = last * r;
            n = n + last;
            count++;
        }
        System.out.println(count);
    }
}
