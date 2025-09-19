package Random;

import java.util.ArrayList;
import java.util.Scanner;

public class PronounceableWrods {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Character> aList = new ArrayList<>();
        aList.add('a');aList.add('e');aList.add('i');aList.add('o');aList.add('u');
        boolean bool = false;
        boolean bool3 = true;
        if (aList.contains(input.charAt(0))) bool = true;
        for (int i = 1; i < input.length(); i++) {
            boolean bool2 = false;
            if (aList.contains(input.charAt(i))) bool2 = true;
            if (bool2 == bool) {
                bool3 = false;
                break;
            }
            bool = bool2;
        }
        if (bool3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
