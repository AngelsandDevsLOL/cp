package COCI;

import java.util.Scanner;

public class Magnus {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] list = new char[]{'H', 'O', 'N', 'I'};
        int count = 0;
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == list[counter]) {
                if (counter == 3) {
                    count++;
                    counter = 0;
                } else {
                    counter++;
                }
            }
        }
        System.out.println(count);
    }
}
