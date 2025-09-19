package CCC.Junior;

import java.util.Scanner;

public class IronScaling {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String apostrophe = "";
        String space = "";
        String times = "";
        for (int i = 0; i < x; i++) {
            apostrophe = apostrophe + "*";
            space = space + " ";
            times = times + "x";
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                for (int j = 0; j < x; j++) {
                    System.out.print(apostrophe);
                    System.out.print(times);
                    System.out.println(apostrophe);
                }
            } else if (i == 1) {
                for (int j = 0; j < x; j++) {
                    System.out.print(space);
                    System.out.print(times);
                    System.out.println(times);
                }
            } else {
                for (int j = 0; j < x; j++) {
                    System.out.print(apostrophe);
                    System.out.print(space);
                    System.out.println(apostrophe);
                }
            }
        }
    }
}
