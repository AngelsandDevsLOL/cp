package DMOPC;

import java.util.Scanner;

public class CharliesCrazyConquest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), h = sc.nextInt();
        int[][] ar = new int[n][2];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int d = Integer.parseInt(input[1]) + 1;
            ar[i][0] = input[0].equals("A") ? (d) : -(d);
        }
        int charlieHealth = h;
        int enemyHealth = h;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int d = Integer.parseInt(input[1]) + 1;
            ar[i][1] = input[0].equals("A") ? (d) : -(d);
        }
        int prevEnemy = 1;
        for (int i = 0; i < n; i++) {
            if (ar[i][0] >= 0) {
                if (prevEnemy >= 0) { // not defense
                    enemyHealth -= ar[i][0] - 1;
                }
            } else {
                if (prevEnemy <= 0) { // D D
                    enemyHealth += prevEnemy + 1;
                }
            }
            if (enemyHealth <= 0) {
                System.out.println("VICTORY");
                return;
            }
            if (charlieHealth <= 0) {
                System.out.println("DEFEAT");
                return;
            }
            if (ar[i][1] >= 0) {
                if (ar[i][0] >= 0) { // not defense
                    charlieHealth -= ar[i][1] - 1;
                }
            } else {
                if (ar[i][0] <= 0) {
                    charlieHealth += ar[i][0] + 1;
                }
                if (i == n - 1) {
                    enemyHealth += ar[i][1] + 1;
                }
            }
            if (charlieHealth <= 0) {
                System.out.println("DEFEAT");
                return;
            }
            if (enemyHealth <= 0) {
                System.out.println("VICTORY");
                return;
            }
            prevEnemy = ar[i][1];
        }
        System.out.println("TIE");

    }
}