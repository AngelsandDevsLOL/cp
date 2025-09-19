package ECOO;

import java.util.Scanner;

public class QuintessentialQuestions {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] questionScore = new int[n];
        int[] bestTeacher = new int[n];
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (questionScore[b-1] < c) {
                questionScore[b-1] = c;
                bestTeacher[b-1] = a;
            }
        }
        for (int i = 0; i < n; i++) {
            if (bestTeacher[i] == 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(bestTeacher[i] + " ");
            }
        }
    }
}
