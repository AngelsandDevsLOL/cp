package CCC.Senior;

import java.util.Scanner;

public class testing {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(".")) count++;
        }
        System.out.println(count);
    }
}
