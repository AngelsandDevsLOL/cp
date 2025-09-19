package COCI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ZigZag {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        HashMap<String, ArrayList<String>> hMap = new HashMap();
        HashMap<String, Integer> count = new HashMap();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String input = scanner.nextLine();
            String character = input.substring(0,1);
            if (hMap.containsKey(character)){
                hMap.get(character).add(input);
                Collections.sort(hMap.get(character));
            } else {
                ArrayList<String> list=new ArrayList<>();
                list.add(input);
                hMap.put(character, list);
            }
            count.put(character, 0);
        }
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int x = count.get(input.substring(0,1));
            String[] string = hMap.get(input.substring(0, 1)).toArray(new String[0]);
            int num = x % string.length;
            System.out.println(string[num]);
            count.replace(string[num].substring(0,1), x + 1);
        }
    }
}
