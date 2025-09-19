package CCC.Junior;

import java.util.Scanner;

public class TroublesomeKeys {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine() + " ";
        int x = 0;
        char silly = 'a' - 1;
        char value = 'a' - 1;
        char quiet = '-';
        boolean works = true;
        int i;
        for (i = 0; i < input.length(); i++, x++) {
            // silly first!
            if (input.charAt(i) != input2.charAt(x)) {
                if (silly >= 'a' && input.charAt(i) == silly && input2.charAt(x) == value) {
                    // yay!
                } else if (input.charAt(i) == quiet) {
                    x--;
                    // yay!
                } else if (silly >= 'a') {
                    // maybe quiet?
                    if (quiet == '-') {
                        quiet = input.charAt(i);
                        x--;
                    } else {
                        works = false;
                        break;
                    }
                } else {
                    silly = input.charAt(i);
                    value = input2.charAt(x);
                }
            }
        }
        if (works && x == input2.length() - 1 && i == input.length()) {
            System.out.println(silly + " " + value);
            System.out.println(quiet);
        } else {
            silly = 'a' - 1;
            value = 'a' - 1;
            quiet = '-';
            x = 0;
            for (i = 0; i < input.length(); i++, x++) {
                if (input.charAt(i) != input2.charAt(x)) {
                    if (silly >= 'a' && input.charAt(i) == silly && input2.charAt(x) == value) {
                        // yay!
                    } else if (input.charAt(i) == quiet) {
                        x--;
                        // yay!
                    } else if (quiet != '-') {
                        // maybe silly?
                        silly = input.charAt(i);
                        value = input2.charAt(x);
                    } else {
                        quiet = input.charAt(i);
                        x--;
                    }
                }
            }
            System.out.println(silly + " " + value);
            System.out.println(quiet);
        }
    }
}
