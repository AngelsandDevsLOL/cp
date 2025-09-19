package CCC.Junior;

import java.util.Scanner;

public class FavouriteTimes {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long x = (input / 720);
        input = input % 720;
        int time = 1200;
        int count = 0;
        for (int i = 0; i < input; i++) {
            if (String.valueOf(time).endsWith("59")) {
                if (time == 1259) time = 99;
                else {
                    String y = String.valueOf(time).substring(0,String.valueOf(time).length()-2);
                    time = (Integer.parseInt(String.valueOf(time).substring(0,String.valueOf(time).length()-2)) + 1) * 100 - 1;
                }
            }
            time = time + 1;
            if (arithmeticProgression(String.valueOf(time), String.valueOf(time).length())) {
                count++;
            }
        }
        System.out.println(count + (x * 31));
    }
    static boolean arithmeticProgression (String value, int size) {
        int x = Integer.parseInt(value.substring(1, 2)) - Integer.parseInt(value.substring(0, 1));
        for (int i = 0; i < size-2; i++) {
            if (Integer.parseInt(value.substring(i+2, i+3)) - Integer.parseInt(value.substring(i+1, i+2)) != x) {
                return false;
            }
        }
        return true;
    }
}