package DMOPC;

import java.util.Scanner;

public class TreeShopping {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[][][] input = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            input[i][0][0] = sc.nextInt(); input[i][0][1] = sc.nextInt();
            input[i][1][0] = sc.nextInt(); input[i][1][1] = sc.nextInt();
            input[i][2][0] = sc.nextInt(); input[i][2][1] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j][0][0] >= x && x >= input[j][2][0]) {
                    double slope = (input[j][1][1] - input[j][2][1] * 1.0) / (input[j][1][0] - input[j][2][0]);
                    if (input[j][1][1] > input[j][0][1]) {
                        double numy = Math.floor((x - input[j][1][0]) * (slope) + input[j][1][1]);
                        if (y <= numy && y >= input[j][2][1]) {
                            count++;
                        }
                    } else {
                        double numy = Math.ceil(slope*x + input[j][1][1]-input[j][1][0]*slope);
                        if (y >= numy && y <= input[j][2][1]) {
                            count++;
                        }
                    }
                } else if (input[j][0][0] <= x && x <= input[j][2][0]) {
                    double slope = (input[j][1][1] - input[j][2][1] * 1.0) / (input[j][1][0] - input[j][2][0]);
                    if (input[j][1][1] < input[j][0][1]) {
                        double numy = Math.ceil(slope * x + input[j][1][1] - input[j][1][0] * slope);
                        if (y >= numy && y <= input[j][2][1]) {
                            count++;
                        }
                    } else {
                        double numy = Math.floor((x - input[j][1][0]) * (slope) + input[j][1][1]);
                        if (y <= numy && y >= input[j][2][1]) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
