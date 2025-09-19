package SAC;

import java.util.Scanner;

public class MonkeyType {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int t = scanner.nextInt();
        int w = scanner.nextInt();
        System.out.println(w - x);
    }
}
