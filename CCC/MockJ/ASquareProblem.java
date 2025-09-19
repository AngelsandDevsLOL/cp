package CCC.MockJ;

import java.util.*;

public class ASquareProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("A", 10);
        hMap.put("B", 11);
        hMap.put("C", 12);
        hMap.put("D", 13);
        hMap.put("E", 14);
        hMap.put("F", 15);
        hMap.put("G", 16);
        hMap.put("H", 17);
        hMap.put("I", 18);
        hMap.put("J", 19);
        hMap.put("K", 20);
        hMap.put("L", 21);
        hMap.put("M", 22);
        hMap.put("N", 23);
        hMap.put("O", 24);
        hMap.put("P", 25);
        hMap.put("Q", 26);
        hMap.put("R", 27);
        hMap.put("S", 28);
        hMap.put("T", 29);
        hMap.put("U", 30);
        hMap.put("V", 31);
        hMap.put("W", 32);
        hMap.put("X", 33);
        hMap.put("Y", 34);
        hMap.put("Z", 35);
        scanner.nextLine();
        int[][] ar = new int[n][n];
        boolean latinSquare = true;
        for (int i = 0; i < n; i++) {
            String x = scanner.nextLine();
            HashSet<Integer> stuff = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (x.charAt(j) <= 90 && x.charAt(j) >= 65) {
                    char s = x.charAt(j);
                    ar[i][j] = hMap.get(String.valueOf(s));
                } else {
                    ar[i][j] = Integer.parseInt(String.valueOf(x.charAt(j)));
                }
                stuff.add(ar[i][j]);
            }
            if (stuff.size() != n) {
                latinSquare = false;
            }
        }
        if (latinSquare) {
            int topRow = ar[0][0];
            int leftCol = ar[0][0];
            boolean reduced = true;
            for (int i = 1; i < n && reduced; i++) {
                if (ar[0][i] < topRow) {
                    reduced = false;
                }
                if (ar[i][0] < leftCol) {
                    reduced = false;
                }
                topRow = ar[0][i];
                leftCol = ar[i][0];
            }
            if (reduced) {
                System.out.println("Reduced");
            } else {
                System.out.println("Latin");
            }
        } else {
            System.out.println("No");
        }
    }
}
