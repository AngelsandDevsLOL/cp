package SAC;

import java.util.Scanner;

public class NormalProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains("demello")) {
            System.out.println("liar");
        } else {
            System.out.println("what are we going to do?");
        }
    }
}
