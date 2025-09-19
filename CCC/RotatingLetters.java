package CCC;

import java.util.Scanner;
/*
public class RotatingLetters {
    public static void main (String args[]){
        boolean bool = true;
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        for (int i = 0; i < x.length(); i++) {
            String y = x.substring(i,i+1);
            if (!(y.equals("S") || y.equals("H") || y.equals("I") || y.equals("O") || y.equals("Z") || y.equals("X") || y.equals("N"))){
                bool = false;
                break;
            }
        }
        if (bool){
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
*/
public class RotatingLetters {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String strRotate = "IOSHZNX";
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (strRotate.indexOf(input.substring(i,i+1)) >= 0) {
                count++;
            }
        }
        if (count == input.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}