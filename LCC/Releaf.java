package LCC;

import java.util.Scanner;

public class Releaf {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean bool = true;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x / 50.0 < 0.9)  bool = false;
        }
        if (bool) {
            System.out.println("RELEAF");
        } else {
            System.out.println("PANIK");
        }
    }
}
