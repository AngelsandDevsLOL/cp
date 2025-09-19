package CCC.Junior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HiddenPalindrome {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lengthCount = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int num = 0; num < input.length(); num++) {
            int index = 0;
            while (index < input.length()) {
                int i = input.indexOf(input.substring(num,num+1), index);
                if (i == -1)
                    break;
                indexes.add(i);
                index = i + 1;
            }
            for (int i = 0; i < indexes.size()-1; i++) {
                for (int j = indexes.size()-1; j >i; j--) {
                    int x = indexes.get(j);
                    int y = indexes.get(i);
                    String oriString = input.substring(y,x+1);
                    int length = oriString.length();
                    if (isPalindrome(oriString,length)){
                        if (length > lengthCount){
                            lengthCount = length;
                        }
                    }
                }
            }
            indexes.clear();
        }
        System.out.println(lengthCount);
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
}
