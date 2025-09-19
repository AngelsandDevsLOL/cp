package CCC.Senior;

import java.util.Scanner;

public class AliceThroughTheLookingGlass {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (solve(m, x, y)) {
                System.out.println("crystal");
            } else {
                System.out.println("empty");
            }
        }
    }

    static boolean solve(int m, int x, int y) {
        int x0 = (int) (x / Math.pow(5, m - 1));
        int y0 = (int) (y / Math.pow(5, m - 1));
        if (x0 == 0) return false;
        if (x0 > 0 && x0 < 4 && y0 == 0) {
            return true;
        }
        if (x0 == 2 && y0 == 1) {
            return true;
        }
        if (((x0 == 1 || x0 == 3) && y0 == 1) || (x0 == 2 && y0 == 2)) {
            return solve(m - 1, x % (int) Math.pow(5, m - 1), y % (int) Math.pow(5, m - 1));
        }
        return false;
        }
    }
