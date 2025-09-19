package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class PostfixNotation {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(" ");
        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            input.add(temp[i]);
        }
        while (input.size() != 1){
            int num = 0;
            double finalInt = 0;
            String symbol = "";
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i).equals("*") || input.get(i).equals("+") || input.get(i).equals("-") || input.get(i).equals("%") || input.get(i).equals("^") || input.get(i).equals("/")){
                    symbol = input.get(i);
                    num = i;
                    break;
                }
            }
            double num2 = Double.parseDouble(input.get(num-1));
            double num1 = Double.parseDouble(input.get(num-2));
            if (symbol.equals("+")){
                finalInt = num1+num2;
            } else if (symbol.equals("*")){
                finalInt = num1*num2;
            } else if (symbol.equals("/")){
                finalInt = num1/num2;
            } else if (symbol.equals("%")){
                finalInt = num1%num2;
            } else if (symbol.equals("^")){
                finalInt = Math.pow(num1,num2);
            } else if (symbol.equals("-")) {
                finalInt = num1 - num2;
            }
            input.remove(num);
            input.remove(num-1);
            input.set(num-2,String.valueOf(finalInt));
        }
        System.out.println(input.get(0));
    }
}
