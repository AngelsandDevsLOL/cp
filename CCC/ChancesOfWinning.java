package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class ChancesOfWinning {
    static int count = 0;
    public static void main (String args[] ){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt() - 1;
        int g = scanner.nextInt();
        int[] teams = new int[4];
        ArrayList<String> games = new ArrayList();
        games.add(0 + " " + 2);
        games.add(0 + " " + 3);
        games.add(0 + " " + 1);
        games.add(1 + " " + 2);
        games.add(1 + " " + 3);
        games.add(2 + " " + 3);
        for (int i = 0; i < g; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int as = scanner.nextInt();
            int bs = scanner.nextInt();
            if (a < b) {
                games.remove(a + " " + b);
            } else {
                games.remove(b + " " + a);
            }
            if (as < bs) {
                teams[b] = teams[b] + 3;
            } else if (as > bs) {
                teams[a] = teams[a] + 3;
            } else {
                teams[a]++;
                teams[b]++;
            }
        }
        name (teams, games, t);
        System.out.println(count);
    }
    static void name (int[] teams, ArrayList<String> games, int t) {
        if (games.size() == 0) {
            int num = teams[t];
            boolean bool = true;
            for (int i = 0; i < teams.length; i++) {
                if (teams[i] >= num && i != t) {
                    bool = false;
                }
            }
            if (bool) {
                count++;
            }
            return;
        }
        String[] game = games.get(0).split(" ");
        games.remove(0);
        int team1 = Integer.parseInt(game[0]);
        int team2 = Integer.parseInt(game[1]);
        int[] clone = teams.clone();
        ArrayList<String> hold = new ArrayList<>(games);
        clone[team1]+=3;
        name(clone, hold, t);
        clone[team1] = clone[team1] - 2;
        clone[team2] += 1;
        hold = new ArrayList<>(games);
        name(clone, hold, t);
        clone[team1] = clone[team1] - 1;
        clone[team2] += 2;
        hold = new ArrayList<>(games);
        name(clone, hold, t);
     }
}
