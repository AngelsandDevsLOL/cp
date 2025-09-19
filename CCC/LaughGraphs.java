package CCC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class LaughGraphs {
    static String[] getRow(int n){
        String[] dot = new String[n];
        Arrays.fill(dot,".");
        return dot;
    }
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<String[]> array =new LinkedList<>();
        scanner.nextLine();
        String input = scanner.nextLine();
        array.add(getRow(n));
        String[] input2 = new String[n];
        for (int i = 0; i < n; i++) {
            input2[i] = input.substring(i,i+1);
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (input2[i].equals("v")){

                if (array.size()<= x+1){
                    array.add(getRow(n));
                }
                x++;
                array.get(x)[y] = "\\";
                y++;
            } else if (input2[i].equals("^")){

                array.get(x)[y] = "/";
                if (x == 0){
                    array.add(0,getRow(n));
                } else
                    x--;
                y++;
            } else if (input2[i].equals(">")){
                array.get(x)[y] = "_";
                y++;
            }
        }
        String dots = "";
        for (int i = 0; i < n; i++) {
            dots = dots + ".";
        }
        for (int i = 0; i < array.size(); i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                line = line + array.get(i)[j];
            }
            if (!(line.equals(dots))){
                System.out.println(line);
            }
        }
    }
}
