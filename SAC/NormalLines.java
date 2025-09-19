package SAC;

import java.util.Scanner;

public class NormalLines {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        if (x1 == x2) {
            System.out.println("y-axis");
        } else if (y1 == y2) {
            System.out.println("x-axis");
        } else {
            System.out.println("neither");
        }
    }
}
