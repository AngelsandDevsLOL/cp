package CCC;

import java.util.Scanner;

public class PartialGame {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            if (input % 2 == 0){
                even = even + (input/2);
            } else
                odd = odd + ((input+1)/2);
        }
        if (even > odd){
            System.out.println("Duke");
        }  else
            System.out.println("Alice");
    }
}
