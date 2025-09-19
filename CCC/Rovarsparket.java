package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class Rovarsparket {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(97);
        hSet.add(101);
        hSet.add(105);
        hSet.add(111);
        hSet.add(117);
        int[] array = {97, 101, 105, 111, 117};
        for (int i = 0; i < input.length(); i++) {
            char string = input.charAt(i);
            sb.append(string);
            int number = string;
            if (!(hSet.contains(number))){
                int distance = 26;
                char characterrrr = 0;
                for (int j = 0; j < 5; j++) {
                    int num = Math.abs(array[j]-string);
                    if (num < distance){
                        distance = num;
                        characterrrr = (char)(array[j]);
                    }
                }
                sb.append(characterrrr);
                if (string == 122){
                    sb.append(string);
                } else{
                    int num = 0;
                    if (hSet.contains(number+1)){
                        num = 1;
                    }
                    sb.append((char)(string+1+num));
                }
            }
        }
        System.out.println(sb);
    }
}
