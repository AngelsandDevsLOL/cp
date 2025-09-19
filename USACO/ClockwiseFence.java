package USACO;

import java.util.Scanner;

public class ClockwiseFence {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int cw, ccw; cw = 0;  ccw = 0;
            String input = scanner.nextLine();
            for (int j = 0; j < input.length() - 1; j++) {
                if (input.substring(j,j+2).equals("NE")) {
                    cw++;
                } else if (input.substring(j,j+2).equals("ES")) {
                    cw++;
                } else if (input.substring(j,j+2).equals("WN")) {
                    cw++;
                } else if (input.substring(j,j+2).equals("SW")) {
                    cw++;
                } else if (input.substring(j,j+2).equals("NW")) {
                    ccw++;
                } else if (input.substring(j,j+2).equals("EN")) {
                    ccw++;
                } else if (input.substring(j,j+2).equals("SE")) {
                    ccw++;
                } else if (input.substring(j,j+2).equals("WS")) {
                    ccw++;
                }
            }
            if (ccw > cw) {
                System.out.println("CCW");
            } else {
                System.out.println("CW");
            }
        }
    }
}
