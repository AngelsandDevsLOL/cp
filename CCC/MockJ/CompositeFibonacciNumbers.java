package CCC.MockJ;

import java.util.ArrayList;
import java.util.Scanner;

public class CompositeFibonacciNumbers {
    static ArrayList<String> aList;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        aList = new ArrayList<>();
        int x = 0;
        int y = 1;
        aList.add("0");
        while (x + y <= 1e6) {
            int temp = y;
            y += x;
            x = temp;
            aList.add(String.valueOf(y));
        }
        int t =sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            recursion(0, input);
        }
    }
    public static int recursion (int cnt, String input) {
        if (aList.contains(input)) {
            return 1;
        } else if (String.valueOf(input).length() == 1) return -1;
        int sum = 0;
        for (int i = 1; i < input.length(); i++) {
            sum += recursion(cnt, input.substring(0,i));
        }
        return 1;
    }
}
