package CCC.Senior;

import java.util.Scanner;

public class DoubleKnockoutCompetition {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int team = scanner.nextInt();
            int oneLoss = 0;
            int eliminated = 0;
            int count = 0;

            while (true) {
                System.out.println("Round " + count + ": " + team + " undefeated, " + oneLoss + " one-loss, " + eliminated + " eliminated");
                if (team == 0 && oneLoss == 1) {
                    break;
                } else if (team == 1 && oneLoss == 1) {
                    oneLoss = 2;
                    team = 0;
                } else {
                    eliminated = (int) (eliminated + Math.floor(oneLoss / 2));
                    oneLoss = (int) (oneLoss - Math.floor(oneLoss / 2) + Math.floor(team / 2));
                    team = (int) (team - Math.floor(team / 2));
                }
                count += 1;
            }
            System.out.println("There are "+ count+ " rounds.");
        }
    }
}