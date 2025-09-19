package CCC.Junior;

import java.util.Scanner;

public class CyclicShifts {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String cyclicShift = scanner.nextLine();
        boolean bool = false;
        for (int i = 0; i < cyclicShift.length(); i++) {
            if (input.contains(cyclicShift)) {
                bool = true;
                break;
            }
            cyclicShift = cyclicShift.substring(1) + cyclicShift.substring(0,1);
        }
        if (bool) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
