package CCC.Junior;

import java.util.Scanner;

public class ArrangingBooks2 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lCount = 0;
        int mCount = 0;
        int sCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("L")) {
                lCount++;
            } else if (input.substring(i,i+1).equals("M")) {
                mCount++;
            } else {
                sCount++;
            }
        }
        int notL = 0, minL = 0;
        for (int i = 0; i < lCount; i++) {
            if (!input.substring(i,i+1).equals("L")) {
                notL++;
            }
            if (input.substring(i,i+1).equals("M")) {
                minL++;
            }
        }
        int notM = 0, linM = 0;
        for (int i = lCount; i < lCount + mCount; i++) {
            if (!input.substring(i,i+1).equals("M")) {
                notM++;
            } if (input.substring(i,i+1).equals("L")) {
                linM++;
            }
        }
        System.out.println(notL + notM - Math.min(minL, linM));
    }
    public static String swap (String string, int x, int y) {
        return string.substring(0, x) + string.substring(y,y+1) + string.substring(x+1, y) + string.substring(x, x+1) + string.substring(y+1);
    }
}
