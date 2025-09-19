package CCC.Junior;

import java.util.Scanner;

public class DoubleDice {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int antonia = 100;
        int david = 100;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (b > a) antonia -= b;
            else if (a > b) david -= a;
        }
        System.out.println(antonia);
        System.out.println(david);
    }
}
