package YetAnotherContest;

import java.util.Scanner;

public class Betting {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            double a = scanner.nextInt();
            double b = scanner.nextInt();
            double c = scanner.nextInt();
            double d = scanner.nextInt();
            boolean bool = false;
            for (int j = 1; j <= 1000; j++) {
                if (bool) {
                    break;
                }
                for (int k = 1; k <= 1000; k++) {
                    if (((j * (b / a)) > (j + k)) && ((k * (d / c)) > (j * k))) {
                        System.out.println("YES");
                        bool = true;
                        break;
                    }
                }
            }
            if (!bool) {
                System.out.println("NO");
            }
        }
    }
}
