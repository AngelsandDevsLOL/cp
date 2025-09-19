package CCC.Senior;

import java.util.HashMap;
import java.util.Scanner;

public class AttackOfTheCipherTexts {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap();
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        String message = scanner.nextLine();

        for (int i = 0; i < string1.length(); i++) {

            hashMap.put(string2.substring(i,i+1),string1.substring(i,i+1));
        }
        for (int i = 0; i < message.length(); i++) {
            if (hashMap.get(message.substring(i,i+1)) == null){
                System.out.print(".");
            }else
            System.out.print(hashMap.get(message.substring(i,i+1)));

        }
    }
}
