package CCC;

import java.util.Scanner;

public class Modulo2 {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        boolean bool = false;
        for (int i = x; i < 100*x; i = i + x) {
            if (i % y == z){
                bool = true;
                break;
            }
        }
        if (bool){
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
