package CCC.Junior;

import java.util.Scanner;

public class ArrangingBooks3 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lCount = 0;
        int mCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("L")){
                lCount++;
            } else if (input.substring(i,i+1).equals("M")) {
                mCount++;
            }
        }
        int count = 0;
        for (int i = 0; i < lCount; i++) {
            String str = input.substring(i,i+1);
            if (str.equals("L")) {
                continue;
            } else  {
                int x = input.lastIndexOf("L");
                input = swap(input, i, x);
                count++;
            }
        }
        for (int i = lCount+mCount; i < input.length(); i++) {
            String str = input.substring(i,i+1);
            if (str.equals("S")) {
                continue;
            } else  {
                int x = input.indexOf("S");
                input = swap(input, x, i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static String swap (String string, int x, int y) {
        return string.substring(0, x) + string.substring(y,y+1) + string.substring(x+1, y) + string.substring(x, x+1) + string.substring(y+1);
    }
}
