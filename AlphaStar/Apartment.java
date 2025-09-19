package AlphaStar;

import java.util.*;

public class Apartment {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        String[][] ar = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = Integer.toBinaryString(sc.nextInt());
                while (ar[i][j].length() != 4) {
                    ar[i][j] = "0" + ar[i][j];
                }
            }
        }
        int[][] dsu = new int[n][m];
        int counter = 1;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dsu[i][j] == 0) {
                    dsu[i][j] = counter;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    while (!q.isEmpty()) {
                        int x = q.poll(), y = q.poll();
                        for (int k = 0; k < ar[x][y].length(); k++) {
                            if (ar[x][y].charAt(k) == '0' && dsu[x + directions[k][0]][y + directions[k][1]] == 0) {
                                q.add(x + directions[k][0]);
                                q.add(y + directions[k][1]);
                                dsu[x + directions[k][0]][y + directions[k][1]] = counter;
                            }
                        }
                    }
                    counter++;
                }
            }
        }
        System.out.println(counter - 1);
        int[] ans2 = new int[counter];
        int ans3 = 0; // max
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans2[dsu[i][j]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < ar[i][j].length(); k++) {
                    if (ar[i][j].charAt(k) == '1' && check(i + directions[k][0], j + directions[k][1], n, m) && dsu[i + directions[k][0]][j + directions[k][1]] != dsu[i][j])
                        ans3 = Math.max(ans3, ans2[dsu[i][j]] + ans2[dsu[i + directions[k][0]][j + directions[k][1]]]);
                }
            }
        }
        Arrays.sort(ans2);
        System.out.println(ans2[counter - 1]);
        System.out.println(ans3);
    }
    public static boolean check (int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
}
