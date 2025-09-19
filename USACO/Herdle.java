package USACO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Herdle {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[3];
        String[] guesses = new String[3];
        for (int i = 0; i < 3; i++) {
            array[i] = scanner.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            guesses[i] = scanner.nextLine();
        }
        int green = 0;
        int yellow = 0;
        for (int i = 0; i < 3; i++) {
            String cow = array[i];
            String guess = guesses[i];
            HashSet<String> hSet = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                hSet.add(cow.substring(j,j+1));
            }
            for (int j = 0; j < 3; j++) {
                if (guess.substring(j,j+1).equals(cow.substring(j,j+1))) {
                    green++;
                } else if (hSet.contains(guess.substring(j,j+1))){
                    yellow++;
                }
            }
        }
        System.out.println(green);
        System.out.println(yellow);
    }
}
