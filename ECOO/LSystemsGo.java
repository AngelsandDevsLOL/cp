package ECOO;

import java.util.HashMap;
import java.util.Scanner;

public class LSystemsGo {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String[] input = scanner.nextLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            String a = input[2];
            HashMap<String, String> hMap = new HashMap<>();
            for (int j = 0; j < r; j++) {
                String[] inputt = scanner.nextLine().split(" ");
                String c = inputt[0];
                String s = inputt[1];
                hMap.put(c, s);
            }
            String string = "";
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < a.length(); k++) {
                    string = string + hMap.get(a.substring(k,k+1));
                }
                a = string;
                string = "";
            }
            System.out.println(a.substring(0,1) + a.substring(a.length() - 1) + " " + a.length());
        }
    }
}
