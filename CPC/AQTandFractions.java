package CPC;

import java.util.Scanner;

public class AQTandFractions {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            double a = scanner.nextLong();
            double b = scanner.nextLong();
           // simplifying(a,b);
            String fraction = String.valueOf(a/b);
            String substring = fraction.substring(2);
            if (b != 2 && b != 5 && b % 4 != 0 && b % 25 != 0){
                System.out.println(-1);
            } else
                System.out.println(substring.length());
        }
    }
}
