package CCC.Junior;

import java.util.Scanner;

public class ArrangingBooks4 {
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
        int sCountL = 0;
        int mCountL = 0;
        int sCountM = 0;
        int lCountM = 0;
        for (int i = 0; i < lCount; i++) {
            String str = input.substring(i,i+1);
            if (str.equals("S")) {
                sCountL++;
            } else if (str.equals("M")) {
                mCountL++;
            }
        }
        for (int i = lCount; i < mCount + lCount; i++) {
            String str = input.substring(i,i+1);
            if (str.equals("S")) {
                sCountM++;
            } else if (str.equals("L")) {
                lCountM++;
            }
        }
        System.out.println(sCountL + mCountL + sCountM + lCountM - Math.min(mCountL, lCountM));
    }
}
