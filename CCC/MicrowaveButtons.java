package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class MicrowaveButtons {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(":");
        int hours = Integer.parseInt(input[0]);
        int minutes = Integer.parseInt(input[1]);
        int second = Integer.parseInt(input[2]);
        String time = String.valueOf((hours * 3600) + (minutes * 60) + second);
        String buttons = scanner.nextLine();
        ArrayList<Integer> broken = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (!(buttons.contains(String.valueOf(i)))){
                broken.add(i);
            }
        }
        for (int i = 0; i < broken.size(); i++) {
            if (time.contains(String.valueOf(broken.get(i)))){
                int x = time.indexOf(String.valueOf(broken.get(i)));
                int number = 10;
                int numm = 0;
                if (x != -1){
                    for (int j = 0; j < buttons.length(); j++) {
                        int num = Math.abs(Integer.parseInt(buttons.substring(j,j+1))-(broken.get(i)));
                        if (num < number){
                            number = num;
                            numm = j;
                        }
                    }
                }
                while (x != -1){
                    String a = time.substring(0,x);
                    String b = time.substring(x, time.length()-1);
                    time = (a + numm + b);
                    x = time.indexOf(String.valueOf(broken.get(i)),x);
                }
            }
        }
        System.out.println(time);
    }
}
