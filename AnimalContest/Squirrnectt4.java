package AnimalContest;

import java.util.Scanner;

public class Squirrnectt4 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            if (w == 1) {
                System.out.println("bad");
            } else if (w == 2 && h <= 3) {
                System.out.println("bad");
            } else if (w == 3 && h <= 3) {
                System.out.println("bad");
            } else if (w == 4 && h < 2) {
                System.out.println("bad");
            } else if (w == 5 && h < 2) {
                System.out.println("bad");
            } else if (w == 6 && h < 2) {
                System.out.println("bad");
            } else {
                System.out.println("good");
            }
        }
    }
}
