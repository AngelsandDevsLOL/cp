package CCC.Senior;

import java.util.Scanner;

public class CoolNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int count = 0;
        for (int i = (int) Math.ceil(Math.cbrt(a)); i <= Math.cbrt(b); i++) {
            int num = i * i * i;
            if (Math.pow((int)Math.sqrt(num), 2) == num) {
count++;            }
        }
        System.out.println(count);
    }
}
