package Random;

import java.util.Scanner;

public class ORdeal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String bin = Long.toBinaryString(Long.parseLong(x));
        for (int i = 0; i < bin.length(); i++) {
            System.out.print(1);
        }
    }
}
