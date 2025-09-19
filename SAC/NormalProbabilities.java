package SAC;

import java.util.Scanner;

public class NormalProbabilities {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double x = 1;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.equals("B")) {
                x = x * 0.8;
            } else if (input.equals("C")) {
                x = x * 0.6;
            } else if (input.equals("D")) {
                x = x * 0.4;
            } else if (input.equals("E")) {
                x = x * 0.2;
            }
        }
        String result = String.format("%.8f", x);
        System.out.println(result);
    }
}