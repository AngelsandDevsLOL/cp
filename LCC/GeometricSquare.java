package LCC;

import java.util.Scanner;

public class GeometricSquare {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        double[][] ar = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ar[i][j] = scanner.nextDouble();
            }
        }
        boolean bool = true;
        if (ar[1][0] / ar[0][0] != ar[2][0]/ar[1][0]) bool = false;
        if (ar[1][1] / ar[0][1] != ar[2][1]/ar[1][1]) bool = false;
        if (ar[1][2] / ar[0][2] != ar[2][2]/ar[1][2]) bool = false;
        if (ar[1][1] / ar[1][0] != ar[1][2]/ar[1][1]) bool = false;
        if (ar[0][1] / ar[0][0] != ar[0][2]/ar[0][1]) bool = false;
        if (ar[2][1] / ar[2][0] != ar[2][2]/ar[2][1]) bool = false;
        if (bool) System.out.println("GOOD");
        else System.out.println("BAF");
    }
}
