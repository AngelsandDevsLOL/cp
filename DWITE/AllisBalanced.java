package DWITE;

import java.util.Scanner;

public class AllisBalanced {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            boolean bool = true;
            String string = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < string.length(); j++) {
                if (string.substring(j,j+1).equals("(") || string.substring(j,j+1).equals(")") || string.substring(j,j+1).equals("[") || string.substring(j,j+1).equals("]") ||string.substring(j,j+1).equals("{") ||string.substring(j,j+1).equals("}")){
                    sb.append(string.substring(j,j+1));
                }
            }
            int x = 0;
            while (x+2<=sb.length()){
                String digits = sb.substring(x,x+2);
                if (digits.equals("()") || digits.equals("{}") || digits.equals("[]")){
                    String stringg = String.valueOf(sb);
                    sb.setLength(0);
                    String fPart = stringg.substring(0,x);
                    int length = stringg.length();
                    String sPart = stringg.substring(x+2,length);
                    sb.append(fPart);
                    sb.append(sPart);
                    if (x >= 1){
                        x = x-1;
                    }
                } else
                    x++;
            }
            if (sb.length() !=0){
                bool = false;
            }
            if (bool){
                System.out.println("balanced");
            } else
                System.out.println("not balanced");
        }
    }
}