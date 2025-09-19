package MALD;

import java.util.Scanner;

public class ScratchCatAndExaminations {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            double g = scanner.nextDouble();
            double t = scanner.nextDouble();
            double percentage = Math.ceil((g / t) * 100);
            if (percentage > 100) {
                System.out.println("sus");
            } else if (percentage == 100) {
                System.out.println("average");
            } else if (percentage < 90) {
                System.out.println("find a new home");
            } else if (percentage >= 90 && percentage <= 94) {
                System.out.println("don't come home");
            } else if (95 <= percentage && percentage <= 97) {
                System.out.println("can't eat dinner");
            } else if (98 <= percentage && percentage <= 99) {
                System.out.println("below average");
            }
        }
    }
}
