package CCC.Junior;

import java.util.Scanner;

public class Punchy {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int A = 0;
        int B = 0;
        while (!input[0].equals("7")) {
            String x = input[0];
            String y = input[1];
            if (x.equals("1")) {
                if (y.equals("A")) {
                    A = Integer.parseInt(input[2]);
                } else {
                    B = Integer.parseInt(input[2]);
                }
            } else if (x.equals("2")) {
                if (y.equals("A")) {
                    System.out.println(A);
                } else {
                    System.out.println(B);
                }
            } else if (x.equals("3")) {
                if (y.equals("A")) {
                    if ((input[2]).equals("A")) {
                        A = A + A;
                    } else
                        A = A + B;
                } else {
                    if ((input[2]).equals("A")) {
                        B = B + A;
                    } else
                        B = B + B;
                }
            } else if (x.equals("4")) {
                if (y.equals("A")) {
                    if ((input[2]).equals("A")) {
                        A = A * A;
                    } else
                       A = A * B;
                } else {
                    if ((input[2]).equals("A")) {
                        B = A * B;
                    } else
                        B = B * B;
                }
            } else if (x.equals("5")) {
                if (y.equals("A")) {
                    if ((input[2]).equals("A")) {
                        A = 0;
                    } else
                         A = A - B;
                } else {
                    if ((input[2]).equals("A")) {
                        B = B - A;
                    } else
                         B = 0;
                }
            } else {
                if (y.equals("A")) {
                    if ((input[2]).equals("A")) {
                        A = 1;
                    } else
                        A = A / B;
                } else {
                    if ((input[2]).equals("A")) {
                        B = B / A;
                    } else
                     B = 1;
                }
            }
            input = scanner.nextLine().split(" ");
        }

    }}
