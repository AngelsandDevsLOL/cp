package com.angelsanddevslol.calcengine;

import java.util.HashMap;
import java.util.Scanner;

public class SnakesAndLadders {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int number = 1;
        hMap.put(9, 34);
        hMap.put(54, 19);
        hMap.put(90, 48);
        hMap.put(40, 64);
        hMap.put(67, 86);
        hMap.put(99, 77);
        int input = scanner.nextInt();
        while (input != 0 && number < 100){
            if (!(number + input > 100)) {
                number = number + input;
                if (hMap.containsKey(number)) {
                    number = hMap.get(number);
                }
            }
            System.out.println("You  are now on square " + number);
            if (number != 100) {
                input = scanner.nextInt();
            }
        }
        if (input == 0){
            System.out.println("You Quit!");
        } else
            System.out.println("You Win!");
    }
}
