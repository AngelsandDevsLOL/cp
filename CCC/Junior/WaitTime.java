package CCC.Junior;

import java.util.Scanner;
import java.util.TreeMap;

public class WaitTime {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int time = 0;
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        TreeMap<Integer, Integer> sum = new TreeMap<>();
        scanner.nextLine();
        String pastCommand = "";
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            int name = Integer.parseInt(input[1]);
            if (command.equals("W")) {
                time = time + name;
                time--;
            } else if (command.equals("R")) {
                tMap.put(name, time);
                time++;
            } else if (command.equals("S")) {
                int x = tMap.get(name);
                tMap.remove(name);
                if (sum.containsKey(name)) {
                    sum.replace(name, sum.get(name) + (time - x));
                } else {
                    sum.put(name, time - x);
                }
                time++;
            }
        }
        for (int integer : tMap.keySet()) {
            sum.put(integer, -1);
        }
        for (int integer : sum.keySet()) {
            System.out.println(integer + " " + sum.get(integer));
        }
    }
}
