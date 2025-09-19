package CCC;

import java.util.Scanner;

public class HappyOrSad {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        int smileCount = 0;
        int frownCount = 0;
        for (int i = 0; i < x.length()-3; i++) {
            if (x.substring(i,i+3).equals(":-)")){
                smileCount++;
            } else if (x.substring(i,i+3).equals(":-(")){
                frownCount++;
            }
        }
        if (smileCount > frownCount){
            System.out.println("happy");
        } else if (frownCount > smileCount) {
            System.out.println("sad");
        } else if (frownCount == smileCount && frownCount !=0){
            System.out.println("unsure");
        } else
            System.out.println("none");
    }
}
