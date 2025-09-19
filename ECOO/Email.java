package ECOO;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Email {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] integerArray = new int[10];
        for (int i = 0; i < 10; i++) {
            int x = scanner.nextInt();
            scanner.nextLine();
            Set uniqueSet=new HashSet(x);
            for (int j = 0; j < x; j++) {
                String input = scanner.nextLine().toLowerCase();
                String string = "";
                int y = input.indexOf("@");
                for (int k = 0; k < y; k++) {
                    String character = input.substring(k,k+1);
                    if (character.equals("+")){
                        break;
                    }
                    else if (!(character.equals("."))){
                        string = string + character;
                    }
                }
                string = string + input.substring(y,input.length());
                uniqueSet.add(string);
            }
            integerArray[i] = uniqueSet.size();
        }
        for (int i = 0; i < integerArray.length; i++) {
            System.out.println(integerArray[i]);
        }
    }
}
