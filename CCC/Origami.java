package CCC;

import java.util.Scanner;

public class Origami {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int cuts = 0;
        int x = 1;
        while (k >= cuts){
            if (x * 2 <= n){
                x = x * 2;
            }
           // (n - (2 * x)) / k;
        }
    }
}
