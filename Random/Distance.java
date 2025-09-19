package Random;

import java.util.Scanner;

public class Distance {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 1;
        while (n != x) {
            System.out.print(x + " ");
            System.out.print(n + " ");
            x++;
            if (x == n) {
                break;
            }
            n--;
            if (x == n) {
                System.out.println(x + " ");
            }
        }
    }
}
