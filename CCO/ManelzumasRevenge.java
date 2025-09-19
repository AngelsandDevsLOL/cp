package CCO;

import java.util.Scanner;

public class ManelzumasRevenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '?') ar[n - i - 1][j] = 2;
                else if (input.charAt(j) == '!') ar[n - i - 1][j] = 1;
            }
        }
        int k = sc.nextInt() + 1;
        try {
            int bottom = sc.nextInt();
            while (bottom != -1) {
                int top = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
                for (int i = top; i >= bottom; i--) {
                    for (int j = l; j <= r; j++) {
                        double temp = (i - 1) / Math.pow(n, k - 1);
                        temp = Math.floor(temp);

                        if (temp == k) {
                            System.out.print("*");
                            continue;
                        }

                        boolean print = false;
                        for (int m = 1; m < k - temp; m++) {
                            int indX = (int) ((i - 1) / Math.pow(n, k - m - 1)) % n;
                            int indY = (int) ((j - 1) / Math.pow(n, k - m - 1)) % n;
                            if (ar[indX][indY] == 0) {
                                System.out.print(" ");
                                print = true;
                                break;
                            } else if (ar[indX][indY] == 1) {
                                System.out.print("*");
                                print = true;
                                break;
                            }
                        }
                        if (!print) System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println();
                bottom = sc.nextInt();
            }
        }
        catch (Exception e) {
            return;
        }
    }
}