package AlphaStar;

import java.util.Scanner;

public class PokeCow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        boolean working = true;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            points[i][0] = x; points[i][1] = y;
        }
    }
}
