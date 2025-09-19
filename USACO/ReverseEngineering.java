package USACO;

import java.util.Scanner;

public class ReverseEngineering {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            int[] ar = new int[n];
            int m = scanner.nextInt();
            scanner.nextLine();
            boolean bool = true;
            for (int j = 0; j < m; j++) {
                String[] input = scanner.nextLine().split(" ");
                /*if (bool && function(input[0]) != Integer.parseInt(input[1])) {
                    bool = false;
                }*/
            }
        }
    }
}
