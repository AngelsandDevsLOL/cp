package CCC.Senior;

import java.util.HashMap;
import java.util.Scanner;

public class AAsigningPartners {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, String> hMap = new HashMap<>();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        boolean bool = true;
        for (int i = 0; i < n; i++) {
            String name1 = input[i];
            String name2 = input2[i];
            if (name1.equals(name2)) {
                bool = false;
                break;
            }
            hMap.put(name1, name2);
            if (hMap.containsKey(name2) && !(hMap.get(name2).equals(name1))) {
                bool = false;
                break;
            }
        }
        if (bool) {
        for (int i = 0; i < n; i++) {
            if (!(hMap.get(input[i]).equals(input2[i]))|| !(hMap.get(input2[i]).equals(input[i]))) {
                bool = false;
                break;
            }
        }
        }
        if (bool) {
            System.out.println("good");
        } else
            System.out.println("bad");
    }
}
