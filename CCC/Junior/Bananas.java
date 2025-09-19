package CCC.Junior;

import java.util.Scanner;

public class Bananas {
    static boolean bool = true;
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (!string.equals("X")) {
            bool = true;
            monkeyword(string, string.length());
            if (bool) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            string = scanner.nextLine();
        }
    }
    static void monkeyword(String x, int index) {
        if (aword(x, index)) {
            if (x.substring(index+1, index+2).equals("N")) {
                index++;
            }
        } else {
            bool = false;
            return;
        }
    }
    static boolean aword(String x, int index) {
        if (x.substring(index, index+1).equals("A") || x.substring(index, index + 1).equals("B")) {
            if (x.substring(index, index + 1).equals("A")) {
                return true;
            }
            // b
            int indexx = x.indexOf("S");
            if (indexx == -1) {
                bool = false;
                return false;
            }

        }
        return false;
    }
}
