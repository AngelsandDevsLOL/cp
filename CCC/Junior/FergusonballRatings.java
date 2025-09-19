package CCC.Junior;

import java.util.Scanner;

public class FergusonballRatings {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a * 5 - b * 3 > 40) {
                count++;
            }
        }
        if (count == n) {
            System.out.println(count + "+");
        } else {
            System.out.println(count);
        }
    }
}
