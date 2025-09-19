package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class Lozinka {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> hSet = new HashSet<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (isPalindrome(input, input.length())){
                    System.out.print(input.length() + " " + input.charAt(input.length()/2));
                    break;
            } else {
                hSet.add(input);
                if (hSet.contains(reverse(input))){
                    System.out.println(input.length() + " " + input.charAt(input.length()/2));
                    break;
                }
            }
        }
    }
    static boolean isPalindrome(String oriString, int length){
        boolean bool = true;
        for (int beginIndex = 0; beginIndex < length; beginIndex++) {
            if(oriString.charAt(beginIndex) != oriString.charAt(length -1-beginIndex)) {
                bool = false;
                break;
            }
        }
        return bool;
    }
    static String reverse (String x){
        StringBuilder sb = new StringBuilder();
        for (int i = x.length(); i > 0; i--) {
            sb.append(x.substring(i-1,i));
        }
        return String.valueOf(sb);
    }
}
