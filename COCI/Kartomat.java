package COCI;

import java.util.HashMap;
import java.util.Scanner;

public class Kartomat {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[x];
        for (int i = 0; i < x; i++) {
            array[i] = scanner.nextLine();
        }
        String string = scanner.nextLine();
        String line1 = "********";
        String line2 = "********";
        String line3 = "********";
        String line4 = "********";
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("A", "0 3");
        hMap.put("B", "0 4");
        hMap.put("C", "0 5");
        hMap.put("D", "0 6");
        hMap.put("E", "0 7");
        hMap.put("F", "1 0");
        hMap.put("G", "1 1");
        hMap.put("H", "1 2");
        hMap.put("I", "1 3");
        hMap.put("J", "1 4");
        hMap.put("K", "1 5");
        hMap.put("L", "1 6");
        hMap.put("M", "1 7");
        hMap.put("N", "2 0");
        hMap.put("O", "2 1");
        hMap.put("P", "2 2");
        hMap.put("Q", "2 3");
        hMap.put("R", "2 4");
        hMap.put("S", "2 5");
        hMap.put("T", "2 6");
        hMap.put("U", "2 7");
        hMap.put("V", "3 0");
        hMap.put("W", "3 1");
        hMap.put("X", "3 2");
        hMap.put("Y", "3 3");
        hMap.put("Z", "3 4");
        for (int i = 0; i < x; i++) {
            String stringggg = array[i].substring(0, string.length());
            if (array[i].substring(0, string.length()).equals(string)) {
                if (!(array[i].equals(string))) {
                    String character = array[i].substring(string.length(), string.length()+1);
                    String[] stringg = hMap.get(character).split(" ");
                    int num = Integer.parseInt(stringg[0]);
                    int num2 = Integer.parseInt(stringg[1]);
                    if (num == 0) {
                        line1 = line1.substring(0, num2) + character + line1.substring(num2 + 1);
                    } else if (num == 1) {
                        line2 = line2.substring(0, num2) + character + line2.substring(num2 + 1);
                    } else if (num == 2) {
                        line3 = line3.substring(0, num2) + character + line3.substring(num2 + 1);
                    } else if (num == 3) {
                        line4 = line4.substring(0, num2) + character + line4.substring(num2 + 1);
                    }
                }
            }
        }
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }
}
