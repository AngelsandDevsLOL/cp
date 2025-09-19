package ECOO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WhenYouEatYourSmarties {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> colours = new HashMap<>();
        colours.put("orange", 0);
        colours.put("blue", 1);
        colours.put("green", 2);
        colours.put("yellow", 3);
        colours.put("pink", 4);
        colours.put("violet", 5);
        colours.put("brown", 6);
        colours.put("red", 7);
        for (int i = 0; i < 10; i++) {
            String input = sc.nextLine();
            HashMap<Integer, Integer> hMap = new HashMap<>();
            hMap.put(0, 0); hMap.put(1,0); hMap.put(2, 0); hMap.put(3, 0); hMap.put(4, 0); hMap.put(5, 0); hMap.put(6, 0); hMap.put(7, 0);
            while (!input.equals("end of box")) {
                int option = colours.get(input);
                hMap.put(option, hMap.get(option) + 1);
                input = sc.nextLine();
            }
            int time = 0;
            for (int j = 0; j <= 6; j++) {
                int count = hMap.get(j);
                time += 13 * Math.ceil(count / 7.0);
            }
            time += 16 * hMap.get(7);
            System.out.println(time);
        }
    }
}
