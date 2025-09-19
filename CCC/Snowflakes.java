package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class Snowflakes {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> set = new HashSet();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().strip();

            //set.add((String.valueOf(array[0]) + String.valueOf(array[1]) + String.valueOf(array[2]) + String.valueOf(array[3]) + String.valueOf(array[4]) + String.valueOf(array[5])));
        }
        if (set.size() != n){
            System.out.println("Twin snowflakes found.");
        } else
            System.out.println("No two snowflakes are alike.");
    }
}