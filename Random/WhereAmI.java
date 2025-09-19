package Random;

import java.util.Scanner;

public class WhereAmI {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String string = scanner.next();
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (!(string.substring(i + 1).contains(string.substring(i, j)))) {
                    break;
                } else if (k < string.substring(i, j).length()) {
                    k = string.substring(i, j).length();
                }
            }
        }
        System.out.println(k+1);
    }
}