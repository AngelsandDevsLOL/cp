package DMOPC;

import java.util.ArrayList;
import java.util.Scanner;

public class OnTheClock {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double m = scanner.nextDouble();
        int count = 0;
        ArrayList<String> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = (int) (m/n * (i));
            int y = (int) Math.ceil(m/n * (i + 1));
            for (int j = x; j < y; j++) {
                aList.add((i + 1) + " " + (j + 1));
            }
        }
        System.out.println(aList.size());
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }
    }
}
