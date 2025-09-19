package BackToSchool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kicking {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            Queue<Integer> q = new LinkedList<>();
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'A') {
                    q.add(j);
                    ar[i][j] = 1;
                } else if (input.charAt(j) == 'B') {
                    if (q.isEmpty()) ar[i][j] = 1;
                    else {
                        ar[i][j] = -1;
                        while (q.size() != 1) {
                            ar[i][q.poll()] = -1;
                        }
                        ar[i][q.peek()] = -1;
                    }
                }
                if (!q.isEmpty() && q.peek() <= j - k) q.poll();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j] == 0) System.out.print(".");
                else if (ar[i][j] == 1) System.out.print("Y");
                else System.out.print("N");
            }
            System.out.println();
        }
    }
}
