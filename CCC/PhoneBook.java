package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, String> hMap = new HashMap();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            hMap.put(input[1], input[0]);
            count.put(input[1], 0);
        }
        int d = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < d; i++) {
            String number = scanner.nextLine();
            count.replace(number,count.get(number)+1);
        }
        int largest = 0;
        int name = 0;
        for (String string : count.keySet()) {
            if (count.get(string) > largest) {
                largest = count.get(string);
                name = Integer.parseInt(string);
            } else if (count.get(string) == largest) {
                if ((name) > Integer.parseInt(string)) {
                    name = Integer.parseInt(string);
                }
            }
        }
        System.out.println(hMap.get(String.valueOf(name)));
    }
}
