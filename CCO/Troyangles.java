package CCO;

import java.util.Scanner;

public class Troyangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        boolean[][] thing = new boolean[n][n];
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == '#') {
                    graph[i][j] = 1;
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 1; j--) {
                if (graph[i][j] == 1) {
                    int smallest = Math.min(graph[i + 1][j], Math.min(graph[i + 1][j - 1], graph[i + 1][j + 1]));
                    graph[i][j] = smallest + 1;
                    count += graph[i][j];
                }
            }
            if (graph[i][0] == 1) count++;
            if (graph[i][n - 1] == 1) count++;
        }
        for (int i = 0; i < n; i++) {
            if (graph[n - 1][i] == 1) count++;
        }
        System.out.println(count);
    }
}