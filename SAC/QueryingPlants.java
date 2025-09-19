package SAC;

import java.util.Scanner;

public class QueryingPlants {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            System.out.print((h + c + c) + " ");
        }
    }
}
