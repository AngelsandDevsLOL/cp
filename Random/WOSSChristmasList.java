package Random;

import java.util.HashMap;
import java.util.Scanner;

public class WOSSChristmasList {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[][] ar = new String[5][5];
        HashMap<String, String> hMap = new HashMap<>();
        HashMap<Integer, String> index = new HashMap<>();
        index.put(0, "A"); index.put(1, "B"); index.put(2,"C"); index.put(3,"D"); index.put(4,"E");
        for (int i = 0; i < 5; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                hMap.put(index.get(i) + String.valueOf(j + 1),input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (input.length()- j >=2) {
                    if (hMap.containsKey(input.substring(j,j+2))) {
                        sb.append(hMap.get(input.substring(j,j+2)));
                        j++;
                    } else {
                        sb.append(input.substring(j,j+1));
                    }
                } else {
                    sb.append(input.substring(j));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
