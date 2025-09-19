package CCC;

import java.util.Scanner;

public class MadScientist {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int count = 0;
        int length = 1;
        while (length <= n){
            if (!(a.substring(length-1,length).equals(b.substring(length-1,length)))){
                while (length <= n && !(a.substring(length - 1, length).equals(b.substring(length - 1, length)))) {
                    length++;
                }
                count++;
            } else
                length++;
        }
        System.out.println(count);
    }
}
