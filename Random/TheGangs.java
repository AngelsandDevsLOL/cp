package Random;

import java.util.Arrays;
import java.util.Scanner;

public class TheGangs {
    static int[] friends;
    static int[] enemies;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        friends = new int[n + 1];
        enemies = new int[n + 1];
        Arrays.fill(friends, -1);
        Arrays.fill(enemies, -1);
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            int in1 = Integer.parseInt(input[1]);
            int in2 = Integer.parseInt(input[2]);
            if (input[0].equals("E")) {
                if (enemies[in1] == -1) {
                    enemies[in1] = in2;
                } else {
                    int parent = parent(enemies[in1], friends);
                    int parent2 = parent(in2, friends);
                    if (parent != parent2) {
                        friends[parent] = parent2;
                    }
                }
                if (enemies[in2] == -1) {
                    enemies[in2] = in1;
                } else {
                    int parent = parent(enemies[in2], friends);
                    int parent2 = parent(in1, friends);
                    if (parent != parent2) {
                        friends[parent] = parent2;
                    }
                }
            } else {
                int parent = parent(in1, friends);
                int parent2 = parent(in2, friends);
                if (parent != parent2) {
                    friends[parent] = parent2;
                    // 2 enemies merge
                    if (enemies[parent] == -1 && enemies[parent2] == -1) {

                    } else if (enemies[parent] == -1) {
                        enemies[parent] = enemies[parent2];
                    } else if (enemies[parent2] == -1) {
                        enemies[parent2] = enemies[parent];
                    } else {
                        int par = parent(enemies[parent], friends);
                        int par2 = parent(enemies[parent2], friends);
                        if (par != par2) {
                            friends[par] = par2;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (friends[i] == -1) count++;
        }
        System.out.println(count);
    }
    public static int parent (int x, int[] ar) {
        if (ar[x] == -1) return x;
        ar[x] = parent(ar[x], ar);
        return ar[x];
    }
}
