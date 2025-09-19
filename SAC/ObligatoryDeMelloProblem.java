package SAC;

import java.util.Scanner;

public class ObligatoryDeMelloProblem {
    public static void main (String args[] ){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            String character = input.substring(i,i+1);
            if (character.equals("a") || character.equals("e") || character.equals("i") || character.equals("u") || character.equals("o") || character.equals("y")) {
                count++;
            }
        }
        if (count >= 2) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
