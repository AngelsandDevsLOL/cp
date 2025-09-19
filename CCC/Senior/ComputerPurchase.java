package CCC.Senior;

import java.util.Scanner;

public class ComputerPurchase {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String highest2 = "";
        String highest = "";
        int highestVal2 = 0;
        int highestVal = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int val = 2 * Integer.parseInt(input[1]) + 3 * Integer.parseInt(input[2]) + Integer.parseInt(input[3]);
            if (val > highestVal) {
                highest2 = highest;
                highestVal2 = highestVal;
                highestVal = val; highest = input[0];
            } else if (val == highestVal) {
                if (highest.compareTo(input[0]) > 0) {
                    highest2 = highest;
                    highestVal2 = highestVal;
                    highest = input[0];
                } else if (val > highestVal2) {
                    highest2 = input[0];
                    highestVal2 = val;
                } else if (val == highestVal2) {
                    if (highest2.compareTo(input[0]) > 0) {
                        highest2 = input[0];
                    }
                }
            } else if (val > highestVal2) {
                highest2 = input[0];
                highestVal2 = val;
            } else if (val == highestVal2) {
                if (highest2.compareTo(input[0]) > 0) {
                    highest2 = input[0];
                }
            }
        }
        System.out.println(highest);
        System.out.println(highest2);
    }
}
