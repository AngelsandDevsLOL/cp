package CCC;

import java.util.*;

public class SilentAuction {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String name = "";
        int amount = 0;
        String name2 = "";
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            name2 = scanner.nextLine();
            int input = scanner.nextInt();
            if (input > amount){
                name = name2;
                amount = input;
            }
        }
        System.out.println(name);
    }
}