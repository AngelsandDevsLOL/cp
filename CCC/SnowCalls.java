package CCC;

import java.util.Scanner;

public class SnowCalls {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] input = new String[t];
        for (int i = 0; i < t; i++) {
            String[] x = scanner.nextLine().split("-");
            String string = "";
            for (int j = 0; j < x.length; j++) {
                string = string + x[j];
            }
            input[i] = string;
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    if (input[i].contains(String.valueOf(ch))) {
                        int integer = 0;
                        if (ch == 'A' || ch == 'B' || ch == 'C') {
                            integer = 2;
                        } else if (ch == 'D' || ch == 'E' || ch == 'F') {
                            integer = 3;
                        } else if (ch == 'G' || ch == 'H' || ch == 'I') {
                            integer = 4;
                        } else if (ch == 'J' || ch == 'K' || ch == 'L') {
                            integer = 5;
                        } else if (ch == 'M' || ch == 'N' || ch == 'O') {
                            integer = 6;
                        } else if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S') {
                            integer = 7;
                        } else if (ch == 'T' || ch == 'U' || ch == 'V') {
                            integer = 8;
                        } else if (ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') {
                            integer = 9;
                        }
                        int num = input[i].indexOf(String.valueOf(ch));
                        String x = input[i].substring(0, num);
                        String y = input[i].substring(num + 1, input[i].length());
                        input[i] = x + integer + y;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(input[i].substring(0,3) + "-" + input[i].substring(3,6) + "-" + input[i].substring(6,10));
        }
    }
}
