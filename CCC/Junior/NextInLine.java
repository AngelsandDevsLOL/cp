package CCC.Junior;

import java.util.Scanner;

public class NextInLine {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(x - y + x);
    }
}
