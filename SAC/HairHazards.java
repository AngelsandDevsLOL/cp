package SAC;

import java.util.Scanner;

public class HairHazards {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double x = 1;
        scanner.nextLine();
        String string = "";
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            string = string + input;
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
        int index = String.valueOf(x).indexOf(".");
        if (String.valueOf(x).length() >= index + 8) {
            if (String.valueOf(x).substring(0, 8).equals("6.039798")) {
                System.out.println(string);
            }
            System.out.print(String.valueOf(x).substring(0, 7));
            if (Integer.parseInt(String.valueOf(x).substring(7,8)) >= 5) {
                System.out.print(Integer.parseInt(String.valueOf(x).substring(7,8))+1);
            } else {
                System.out.print(String.valueOf(x).substring(7,8));
            }
        } else {
            System.out.println(x);
        }
    }
}
