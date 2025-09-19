package CCO;

import java.util.Scanner;

public class GeesevsHawks {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input1 = sc.nextLine();
        int[] geese = new int[n];
        int[] hawks = new int[n];
        for (int i = 0; i < n; i++) {
            geese[i] = sc.nextInt();
        }
        sc.nextLine();
        String input2 = sc.nextLine();
        for (int i = 0; i < n; i++) {
            hawks[i] = sc.nextInt();
        }
        int[][] rounds = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (input1.charAt(i - 1) != input2.charAt(j - 1)) {
                    if (input1.charAt(i - 1) == 'W' && geese[i - 1] > hawks[j - 1]) {
                        rounds[i][j] = Math.max(rounds[i-1][j-1] + geese[i - 1] + hawks[j - 1], Math.max(rounds[i - 1][j], rounds[i][j - 1]));
                    } else if (input1.charAt(i - 1) == 'L' && geese[i - 1] < hawks[j - 1]) {
                        rounds[i][j] = Math.max(rounds[i-1][j-1] + geese[i - 1] + hawks[j - 1], Math.max(rounds[i - 1][j], rounds[i][j - 1]));
                    } else {
                        rounds[i][j] = Math.max(rounds[i - 1][j], Math.max(rounds[i - 1][j], rounds[i][j - 1]));
                    }
                } else {
                    rounds[i][j] = Math.max(rounds[i - 1][j], Math.max(rounds[i - 1][j], rounds[i][j - 1]));
                }
            }
        }
        System.out.println(rounds[n][n]);
    }
}
