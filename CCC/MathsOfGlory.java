package CCC;

import java.util.Scanner;

public class MathsOfGlory {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int team1 = k;
        int team2 = k;
        int player1c = 0;
        int player2c = 0;
        int player3c = 0;
        int player4c = 0;
        int m = scanner.nextInt();
        boolean bool = true;
        for (int i = 0; i < m; i++) {
            player1c = scanner.nextInt();
            player2c = scanner.nextInt();
            player3c = scanner.nextInt();
            player4c = scanner.nextInt();
            team1 = team1 - (player4c*player3c);
            team2 = team2 - (player1c*player2c);
            if (team1 <= 0 && team2 <= 0){
                System.out.println("It's a tie at round " + (i+1) + "!");
                bool = false;
                break;
            } else if (team1 <= 0){
                System.out.println("Team 2 wins at round " + (i+1) + "!");
                bool = false;
                break;
            } else if (team2 <= 0) {
                System.out.println("Team 1 wins at round " + (i+1) + "!");
                bool = false;
                break;
            }
        }
        if (bool){
            System.out.println("Oh no!");
        }
    }
}