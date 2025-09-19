package CPC;

import java.util.Scanner;

public class AQTandAlphabet {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        for (char i = 'a'; i < 'z'; i++) {
            if (!(x.contains(String.valueOf(i)))){
                System.out.println(i);
                break;
            }
        }
    }
}