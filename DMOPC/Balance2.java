package DMOPC;

import java.util.Scanner;


public class Balance2 {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean balanced = true;
        int openCount=0;
        int closeCount=0;
        boolean reversed=false;
        for (int j = 0; j < input.length(); j++) {
            char c=input.charAt(j);
            if (c=='(') {
                openCount++;
            }else if (c==')') {
                closeCount++;
            }
            if (!reversed && closeCount>openCount) {
                reversed=true;
                closeCount--;
                openCount++;
            }else if (closeCount>openCount) {
                balanced=false;
                break;
            }

        }
        int diff=Math.abs(openCount-closeCount);
        if (diff==0 || (diff==2 && !reversed)) {  // balanced or can reverse once to balance
            balanced=true;
        }else  {  // Can't be reversed once
            balanced =false;
        }

        if (balanced){
            System.out.println("YES");
        } else
            System.out.println("NO");
    }

}
