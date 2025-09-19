package Random;

import java.util.Scanner;

public class DivideAndConnor {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ar = sc.nextLine().split(" ");
        String[] output = recursion(ar);
        System.out.println(output[0]);
    }
    public static String[] recursion(String[] str) {
        if (str.length == 1) {
            return str;
        }
        String[] ar = new String[str.length/3];
        for (int i = 0; i + 2 < str.length; i = i + 3) {
            ar[i / 3] = str[i + 2] + " " + str[i] + " " + str[i + 1];
        }
        return recursion(ar);
    }
}
