package CCC;

import java.util.Scanner;

public class MonkeyShopping {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        if (a<b && c < d){
            System.out.println("Go to the department store");
        }else if (a<b){
            System.out.println("Go to the grocery store");
        } else if (c<d){
            System.out.println("Go to the pharmacy");
        } else
            System.out.println("Stay home");
    }
}
