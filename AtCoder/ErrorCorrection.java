package AtCOder;

import java.util.HashSet;
import java.util.Scanner;

public class ErrorCorrection {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String in = sc.nextLine();
            if (input[1].length() == in.length()) {
                int er = 0;
                for (int j = 0; j < in.length(); j++) {
                    if (input[1].charAt(j) != in.charAt(j)) {
                        er++;
                        if (er > 1) break;
                    }
                }
                if (er <= 1) hSet.add(i + 1);
            } else if (input[1].length() == in.length() - 1) {
                int er = 0;
                for (int j = 0; j < input[1].length() && er <= 1; j++) {
                    while (input[1].charAt(j) != in.charAt(j + er)) {
                        er++;
                        if (er > 1) break;
                    }
                }
                if (er <= 1) hSet.add(i + 1);
            } else if (input[1].length() == in.length() + 1) {
                int er = 0;
                for (int j = 0; j < in.length() && er <= 1; j++) {
                    while (input[1].charAt(j + er) != in.charAt(j)) {
                        er++;
                        if (er > 1) break;
                    }
                }
                if (er <= 1) hSet.add(i + 1);
            }
        }
        System.out.println(hSet.size());
        for (int i : hSet) {
            System.out.print(i + " ");
        }
    }
}
