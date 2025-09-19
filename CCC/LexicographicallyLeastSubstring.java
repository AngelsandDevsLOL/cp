package CCC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LexicographicallyLeastSubstring {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = scanner.nextInt();
        ArrayList<String> aList = new ArrayList();
        for (int i = 0; i < string.length()-k+1; i++) {
            aList.add(string.substring(i,i+k));
        }
        Collections.sort(aList);
        System.out.println(aList.get(0));
    }
}
