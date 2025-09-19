package CCC;

import java.util.Scanner;

public class Boolean {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        boolean bool = true;
        if (array[array.length - 1].equals("True")) {
            bool = true;
        } else
            bool = false;
        if (array.length % 2 == 0) {
            if (bool) {
                bool = false;
            } else
                bool = true;
        }
        if (bool) {
            System.out.println("True");
        } else
            System.out.println("False");
    }
}