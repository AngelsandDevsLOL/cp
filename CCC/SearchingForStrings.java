package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class SearchingForStrings {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine(); 
        String h = sc.nextLine();
        HashMap<Character, Integer> nMap = new HashMap<>();
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            char nChar = n.charAt(i);
            if (nMap.containsKey(nChar)) {
                nMap.put(nChar, nMap.get(nChar) + 1);
            }
            else nMap.put(nChar, 1);
            char hChar = h.charAt(i);
            if (hMap.containsKey(hChar)) {
                hMap.put(hChar, hMap.get(hChar) + 1);
            }
            else hMap.put(hChar, 1);
        }
        int count = 0;
        for (int i = n.length() + 1; i < h.length(); i++) {

        }
    }
    // I was thinking about checking but realized my timing would be 200 000 ^ 2 which is > 0.5 sec
}
