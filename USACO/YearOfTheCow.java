package USACO;

import java.util.HashMap;
import java.util.Scanner;

public class YearOfTheCow {
    static HashMap<String, Integer> animals = new HashMap<>();
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        animals.put("Ox", 1);
        animals.put("Tiger", 2);
        animals.put("Rabbit", 3);
        animals.put("Dragon", 4);
        animals.put("Snake", 5);
        animals.put("Horse", 6);
        animals.put("Goat", 7);
        animals.put("Monkey", 8);
        animals.put("Rooster", 9);
        animals.put("Dog", 10);
        animals.put("Pig", 11);
        animals.put("Rat", 12);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, String[]> years = new HashMap<>(); //person, their year
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            years.put(name, input);
        }
        String[] x = recursion("Elsie", years).split(" ");
        System.out.println(Math.abs(Integer.parseInt(x[1])));
    }
    static String recursion (String name, HashMap<String, String[]>years) {
        String[] string = years.get(name);
        if (name.equals("Bessie")) {
            return ("Ox 0");
        } else {
            String[] x = recursion(string[7], years).split(" ");
            int integer = Integer.parseInt(x[1]);
            int second = animals.get(x[0]);
            int first = animals.get(string[4]);
            if (string[3].equals("previous")) {
                if (second > first) {
                    integer = integer + (first - second);
                } else {
                    integer = integer + (-1 * (second + 12 - first));
                }
            } else {
                if (second < first) {
                    integer = integer + first - second;
                } else {
                    integer = integer + (12 - second + first);
                }
            }
            return (string[4] + " " + integer);
        }
    }
}
