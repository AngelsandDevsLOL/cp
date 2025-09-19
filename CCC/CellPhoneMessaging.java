package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class CellPhoneMessaging {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, Integer> hMap = new HashMap();
        hMap.put("a", 2);
        hMap.put("b", 2);
        hMap.put("c", 2);
        hMap.put("d", 3);
        hMap.put("e", 3);
        hMap.put("f", 3);
        hMap.put("g", 4);
        hMap.put("h", 4);
        hMap.put("i", 4);
        hMap.put("j", 5);
        hMap.put("k", 5);
        hMap.put("l", 5);
        hMap.put("m", 6);
        hMap.put("n", 6);
        hMap.put("o", 6);
        hMap.put("p", 7);
        hMap.put("q", 7);
        hMap.put("r", 7);
        hMap.put("s", 7);
        hMap.put("t", 8);
        hMap.put("u", 8);
        hMap.put("v", 8);
        hMap.put("w", 9);
        hMap.put("x", 9);
        hMap.put("y", 9);
        hMap.put("z", 9);

        String b = "";
        while (!(input.equals("halt"))) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                String a = input.substring(i,i+1);
                count++;
                if (a.equals("b")) {
                    count++;
                } else if (a.equals("c")) {
                    count = count + 2;
                } else if (a.equals("e")) {
                    count++;
                } else if (a.equals("f")) {
                    count = count + 2;
                } else if (a.equals("h")) {
                    count++;
                } else if (a.equals("i")) {
                    count = count + 2;
                } else if (a.equals("k")) {
                    count++;
                } else if (a.equals("l")) {
                    count = count + 2;
                } else if (a.equals("n")) {
                    count++;
                } else if (a.equals("o")) {
                    count = count + 2;
                } else if (a.equals("r")) {
                    count++;
                } else if (a.equals("s")) {
                    count = count + 3;
                } else if (a.equals("q")) {
                    count = count + 2;
                } else if (a.equals("u")) {
                    count++;
                } else if (a.equals("v")) {
                    count = count + 2;
                } else if (a.equals("x")) {
                    count++;
                } else if (a.equals("y")) {
                    count = count + 2;
                } else if (a.equals("z")) {
                    count = count + 3;
                }
                if (hMap.get(a).equals(hMap.get(b))) {
                    count = count + 2;
                }
                b = a;
            }
            System.out.println(count);
            b = "";
            input = scanner.nextLine();
        }
    }
}
