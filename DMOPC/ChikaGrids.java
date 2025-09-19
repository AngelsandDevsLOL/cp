package DMOPC;

import java.util.Scanner;

public class ChikaGrids {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        if (n == 1 || m == 1) {
            long[] array = new long[Math.max(n, m)];
            for (int i = 0; i < Math.max(n, m); i++) {
                array[i] = scanner.nextInt();
                if (array[i] == 0) {
                    if (i == 0) {
                        array[i] = 1;
                    } else {
                        array[i] = array[i - 1] + 1;
                    }
                }
            }
            if (n == 1) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
            } else {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            }
        } else {
            boolean bool = true;
            long[][] array = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (array[i][j] == 0 && bool) {
                        if (i == 0 && j == 0) {
                            array[i][j] = 1;
                        } else if (i == 0 && j == m - 1) {
                            if (array[i][j-1] + 1 < array[i + 1][j] || array[i + 1][j] == 0) {
                                array[i][j] = array[i][j-1] + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        } else if (i == 0) {
                            long max = array[i + 1][j];
                            if (array[i][j + 1] < max) {
                                max = array[i][j + 1];
                            } else {
                                bool = false;
                                break;
                            }
                        } else if (i == n - 1 && j != 0 && j != m - 1) {
                            // left, up, right
                            long min = Math.max(array[i - 1][j], array[i][j - 1]);
                            if (min + 1 < array[i][j + 1] || array[i][j + 1] == 0) {
                                array[i][j] = min + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        } if (j == 0 && i == n - 1) {
                            if (array[i - 1][j] + 1 < array[i][j + 1] || array[i][j + 1] == 0) {
                                array[i][j] = array[i - 1][j] + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        } else if (j == m - 1 && i == n - 1) {
                            long min = Math.max(array[i][j - 1], array[i - 1][j]);
                            array[i][j] = min + 1;
                            continue;
                        } else if (j == 0 && i != 0 && i != n - 1) {
                            // top, right, down
                            long max = array[i][j + 1];
                            if (array[i + 1][j] < max) {
                                max = array[i + 1][j];
                            }
                            if (array[i - 1][j] + 1 < max) {
                                array[i][j] = array[i - 1][j] + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        } else if (j == m - 1 && i != 0 && i != n - 1) {
                            // top, left, down
                            long min = Math.max(array[i-1][j], array[i][j-1]);
                            if (min + 1 < array[i + 1][j] || array[i + 1][j] == 0) {
                                array[i][j] = min + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        } else if (i != 0 && i != n - 1 && j != 0 && j != m - 1){
                            long min = Math.max(array[i-1][j], array[i][j-1]);
                            long max = array[i][j + 1];
                            if (array[i + 1][j] < max) {
                                max = array[i + 1][j];
                            }
                            if (min + 1 < max) {
                                array[i][j] = min + 1;
                            } else {
                                bool = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (bool) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}