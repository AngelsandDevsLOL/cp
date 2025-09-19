package ECOO;

import java.util.Scanner;

public class TakeANumber {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("EOF")) {
            int take = 0;
            int serve = 0;
            while (!input.equals("CLOSE")) {
                if (input.equals("TAKE")) {
                    take++;
                } else {
                    serve++;
                }
                input = scanner.nextLine();
            }
            if (input.equals("CLOSE")) {
                x = x + take;
                if (x >= 999) {
                    x = x - 998;
                }
                System.out.println(take + " " + (take - serve) + " " + x);
                input = scanner.nextLine();
            }
        }
    }
}
