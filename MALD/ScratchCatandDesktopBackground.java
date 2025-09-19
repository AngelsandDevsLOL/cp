package MALD;

import java.util.Scanner;

public class ScratchCatandDesktopBackground {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int count = 0;
        int max = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        for (int i = 0; i <= input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String x = input.substring(i, j);
                double one = 0;
                double zero = 0;
                for (int k = 0; k < x.length(); k++) {
                    if (x.substring(k, k+1).equals("1")) {
                        one++;
                    } else {
                        zero++;
                    }
                }
                double imbalance = Math.abs(one - zero) / Math.abs(x.length()) * 100;
                if (imbalance <= max && imbalance >= min) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
