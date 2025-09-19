package CCC;

import java.util.Scanner;

public class CrazyFencing {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] height = new double[n+1];
        double[] width = new double[n];
        for (int i = 0; i < n + 1; i++) {
            height[i] = scanner.nextInt();
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            width[i] = scanner.nextInt();
            sum = sum + ((height[i] + height[i+1])/2*width[i]);
        }
        int index = String.valueOf(sum).indexOf(".");
        if (String.valueOf(sum).substring(index+1).equals("0")) {
            System.out.println(String.valueOf(sum).substring(0, index));
        } else
            System.out.println(sum);
    }
}
