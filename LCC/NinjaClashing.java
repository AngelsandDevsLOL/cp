package LCC;

import java.util.Scanner;

public class NinjaClashing {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (Integer.parseInt(input[1]) > 9000) {
                System.out.println(input[0]);
            }
        }
    }
}
