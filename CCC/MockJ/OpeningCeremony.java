package CCC.MockJ;

import java.util.Scanner;

public class OpeningCeremony {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int tf = scanner.nextInt();
        int tm = scanner.nextInt();
        int tb = scanner.nextInt();
        int f = scanner.nextInt();
        int m = scanner.nextInt();
        int b = scanner.nextInt();
        long int1 = f + m + b;
        long int2 = (tf * f) + (tm * m) + (tb * b);
        System.out.println(int1 + " " + int2);
    }
}
