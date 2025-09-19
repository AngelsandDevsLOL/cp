package CCC;

import java.util.Scanner;
//un-finished
public class KoalaMatchmaking {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (double i = n-1; i > 0; i--) {
            String string = String.valueOf((n + i)/2);
            int indexOf = string.indexOf('.');
            if (string.substring(indexOf).equals(".0")){
                System.out.println(string.substring(0,indexOf));
                break;
            }
        }
    }
}
