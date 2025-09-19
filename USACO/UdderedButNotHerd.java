package USACO;

import java.util.Scanner;

public class UdderedButNotHerd {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String cowphabet = scanner.nextLine();
        String input = scanner.nextLine();
        int x = 0;
        int y = 0;
        int max = 1;
        int i = 0;
        int length=input.length();
        while (i < length){
            x = cowphabet.indexOf(input.substring(i,i+1));
            i++;
            while (i < input.length() && y != -1){
                String string = input.substring(i,i+1);
                y = cowphabet.indexOf(string,x+1);
                if (y>=0) {
                    i++;
                    x=y;
                }
            }
            y = 0;
            if (i<length) {
                max++;
            }
        }
        System.out.println(max);
    }
}
