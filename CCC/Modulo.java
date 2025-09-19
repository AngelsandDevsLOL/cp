package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class Modulo {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> hSet = new HashSet();
        for (int i = 0; i < 10; i++) {
            int input = scanner.nextInt();
            int remainder = input%42;
            hSet.add(remainder);
        }
        System.out.println(hSet.size());
    }
}
