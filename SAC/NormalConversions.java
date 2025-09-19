package SAC;

import java.util.Scanner;

public class NormalConversions {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long q = scanner.nextLong();
        for (int i = 0; i < q; i++) {
            long b1 = scanner.nextLong();
            long n = scanner.nextLong();
            long b2 = scanner.nextLong();
            long x = 0;
            long sum = 0;
            String ns = String.valueOf(n);
            for (int j = ns.length()-1; j >= 0; j--) {
                long pow = (long) Math.pow(b1, x);
                x++;
                sum = (sum + (Integer.parseInt(ns.substring(j,j+1)) * pow));
            }
            String string = "";
            while (sum >= b2) {
                long remainder = sum % b2;
                string = remainder + string;
                long integer = (sum - remainder) / b2;
                sum = integer;
            }
            string = sum + string;
            String num = string.substring(0,1);
            while (num.equals("0")) {
                string = string.substring(1);
                num = string.substring(0,1);
            }
            System.out.println(string);
        }
    }
}
