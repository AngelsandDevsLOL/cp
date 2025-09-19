package CCC.Junior;

import java.util.Scanner;

public class ArrangingBooks {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lCount = 0;
        int mCount = 0;
        int sCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("L")){
                lCount++;
            } else if (input.substring(i,i+1).equals("M")) {
                mCount++;
            } else if (input.substring(i,i+1).equals("S")) {
                sCount++;
            }
        }
        String string = "";
        for (int i = 0; i < lCount; i++) {
            string = string + "L";
        }
        for (int i = 0; i < mCount; i++) {
            string = string + "M";
        }
        for (int i = 0; i < sCount; i++) {
            string = string + "S";
        }
        while (!(input.equals(string))){
            if (!(input.endsWith(string.substring(string.length()-sCount,string.length())))){

            }
        }
    }
}
