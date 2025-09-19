package USACO;

import java.util.Scanner;

public class WordProcessor {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        int count = 0;
        String[] output = new String[n];
        for (int i = 0; i < n; i++) {
            output[i] = input[i];
        }
        StringBuilder sb = new StringBuilder();
        while (count != n){
            sb.setLength(0);
            sb.append(output[count]);
            System.out.print((output[count]));
            count++;
            if (count !=n) {
                while ((sb.length() + output[count].length()) <= k) {
                    sb.append(output[count]);
                    System.out.print(" " + output[count]);
                    count++;
                    if (count >= n){
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}

