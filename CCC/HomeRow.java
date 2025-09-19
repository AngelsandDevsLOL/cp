package CCC;

import java.util.Scanner;

public class HomeRow {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int x = 0;
        int length = s.length();
        if (t.length() < length){
            length = t.length();
        }
        for (int i = 0; i < length; i++) {
            if (!(s.substring(i,i+1).equals(t.substring(i,i+1)))){
                break;
            } else {
                x++;
            }
        }
        System.out.println(s.length()+t.length()-(2*x));
    }
}