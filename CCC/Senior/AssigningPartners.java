package CCC.Senior;

import java.util.HashMap;
import java.util.Scanner;

public class AssigningPartners {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int names = scanner.nextInt();
        scanner.nextLine();
        boolean bool = true;
        HashMap<String, String> hMap = new HashMap<>();
        String array1[] = scanner.nextLine().split(" ");
        String array2[] = scanner.nextLine().split(" ");
        for (int i = 0; i < names && bool; i++) {
            String x = array1[i];
            String y = array2[i];
            if (hMap.containsKey(x) && !hMap.get(x).equals(y)) {
                bool = false;
                break;
            }
            if (hMap.containsKey(y) && !hMap.get(y).equals(x)) {
                bool = false;
                break;
            }
            if (x.equals(y)) {
                bool = false;
                break;
            }
            hMap.put(x, y);
            hMap.put(y, x);
        }
        if (bool) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }
}
