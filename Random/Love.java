package Random;

import java.util.Scanner;

public class Love {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ltotal = 0;
        long ototal = 0;
        long vtotal = 0;
        long e = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == 'e') {
                e++;
            } else if (s.charAt(i) == 'v') {
                vtotal += e;
            } else if (s.charAt(i) == 'o') {
                ototal += vtotal;
            } else if (s.charAt(i) == 'l') {
                ltotal += ototal;
            }
        }
        System.out.println(ltotal);
    }

}
