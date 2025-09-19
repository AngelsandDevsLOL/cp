package Random;

import java.util.Scanner;

public class DirectedAnger {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String direction = sc.nextLine();
        String[] directions = {"N", "E", "S", "W"};
        int num = 0;
        for (int i = 0;; i++) {
            if (directions[i].equals(direction)) {
                num = i;
                break;
            }
        }
        int l = sc.nextInt() % 4;
        int r = sc.nextInt() % 4;
        int x = (r - l);
        if (x >= 0) {
            x %= 4;
            num += x;
            System.out.println(directions[num % 4]);
        } else {
                x = l - r;
                x %= 4;
                num -= x;
                num += 4;
                System.out.println(directions[num % 4]);
        }
    }
}
