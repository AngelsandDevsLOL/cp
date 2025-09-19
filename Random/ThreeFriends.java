package Random;

import java.util.Scanner;

public class ThreeFriends {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int x = (in.length() - 1) / 2;
        if (in.length() % 2 == 0) { // If the length is even
            System.out.println("NOT POSSIBLE"); return;
        } // length MUST be odd
        String first = in.substring(0, x);
        String second = in.substring(x); // second is longer
        int point = 0; //
        int num1 = -1; // possible place where the string could be
        boolean bool = true;
        for (int i = 0; i < first.length(); i++) {
            while (first.charAt(i) != second.charAt(point) && point == i) {
                point++;
                num1 = point;
            }
            if (first.charAt(i) != second.charAt(point)) {
                bool = false;
                break;
            }
            point++;
        }
        if (num1 == -1) num1 = x; // second.beginsWith(first) = true so the 'error' is at the end
        first = in.substring(0, x + 1);
        second = in.substring(x + 1);
        point = 0;
        boolean bool2 = true;
        int num2 = -1;
        for (int i = 0; i < second.length(); i++) {
            while (first.charAt(point) != second.charAt(i) && point == i) {
                point++;
                num2 = point;
            }
            if (first.charAt(point) != second.charAt(i)) {
                bool2 = false;
                break;
            }
            point++;
        }
        if (num2 == -1) num2 = x;
        if (bool && bool2 && !(num1 == 1 && num2 == x) && !first.substring(0,x).equals(second)) { // it isn't the middle #
            System.out.println("NOT UNIQUE");
        } else if (bool) {
            System.out.println(first.substring(0, x));
        } else if (bool2) {
            System.out.println(second);
        } else
            System.out.println("NOT POSSIBLE");
    }
}
