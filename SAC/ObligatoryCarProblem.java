package SAC;

import java.util.Scanner;

public class ObligatoryCarProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long longg = scanner.nextLong();
        if (longg <= 3) {
            System.out.println(0);
        } else {
            System.out.println(longg-3);
        }
    }
}
