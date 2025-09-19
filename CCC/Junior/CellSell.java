package CCC.Junior;

import java.util.Scanner;

public class CellSell {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int evening = scanner.nextInt();
        int weekend = scanner.nextInt();
        double a = (Math.max(day-100,0)*25) + (15*evening) + (20*weekend);
        double b = (Math.max(day-250,0)*45) + (35*evening) + (25*weekend);
        System.out.println("Plan A costs " + a/100);
        System.out.println("Plan B costs " + b/100);
        if (a < b) {
            System.out.println("Plan A is cheapest.");
        } else if (b < a) {
            System.out.println("Plan B is cheapest.");
        } else {
            System.out.println("Plan A and B are the same price.");
        }
    }
}
