package CCC;

import java.util.Scanner;

public class ModInverse {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int m = scanner.nextInt();
        int modularInverse = 0;
        boolean bool = false;
        for (int i = 0; i < m; i++) {
            int var = x*i;
            if (var % m == 1) {
                modularInverse = i;
                bool = true;
                break;
            }
        }
        if (bool)
        System.out.println(modularInverse);
        else
            System.out.println("No such integer exists.");
    }
}
