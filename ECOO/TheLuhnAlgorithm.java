package ECOO;

import java.util.Scanner;

public class TheLuhnAlgorithm {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String[] ar = scanner.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int y = luhnmodified(ar[j])%10;
                if (y == 0) {
                    System.out.print(0);
                } else {
                    System.out.print(10 - y);
                }
            }
            System.out.println();
        }
    }
    public static int luhnmodified (String x) {
        int sum = 0;
        for (int i = x.length(); i > 0; i = i - 2) {
            int s = (2 * Integer.parseInt(x.substring(i - 1, i)));
            for (int j = 0; j < String.valueOf(s).length(); j++) {
                sum = sum + Integer.parseInt(String.valueOf(s).substring(j,j+1));
            }
        }
        for (int i = x.length()-1; i > 0; i = i - 2) {
            sum = sum + Integer.parseInt(x.substring(i-1, i));
        }
        return sum;
    }
    public static int luhn (String x) {
        int sum = 0;
        for (int i = x.length()-1; i > 0; i = i - 2) {
            sum = sum + (2 * Integer.parseInt(x.substring(i-1, i)));
        }
        for (int i = x.length(); i > 0; i = i - 2) {
            sum = sum + Integer.parseInt(x.substring(i-1, i));
        }
        return sum;
    }
}
