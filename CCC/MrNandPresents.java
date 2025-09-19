package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class MrNandPresents {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        ArrayList<Integer> aList = new ArrayList();
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("F")){
                aList.add(0, Integer.valueOf(input[1]));
            } else if (input[0].equals("E")){
                aList.add(Integer.valueOf(input[1]));
            } else if (input[0].equals("R")){
                aList.remove(aList.indexOf(Integer.parseInt(input[1])));
            }
        }
        for (int i = 0; i < aList.size(); i++) {
            System.out.println(aList.get(i));
        }
    }
}
