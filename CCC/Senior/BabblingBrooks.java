package CCC.Senior;

import java.util.LinkedList;
import java.util.Scanner;

public class BabblingBrooks {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> aList = new LinkedList<>();
        aList.add(0);
        for (int i = 0; i < n; i++) {
            aList.add(scanner.nextInt());
        }
        int input = scanner.nextInt();
        while (input != 77){
            if (input == 99){
                int streamNumber = scanner.nextInt()+1;
                int leftStream = (int) Math.round(scanner.nextInt()*aList.get(streamNumber-1)*0.01);
                int rightStream = aList.get(streamNumber-1)-leftStream;
                aList.remove(streamNumber-1);
                aList.add(streamNumber-1,leftStream);
                aList.add(streamNumber,rightStream);
            } else if (input == 88){
                int number = scanner.nextInt()+1;
                int leftStream = aList.get(number-1);
                int rightStream = aList.get(number);
                aList.remove(number);
                aList.remove(number-1);
                aList.add(number-1,leftStream+rightStream);
            }
            input = scanner.nextInt();
        }
        for (int i = 1; i < aList.size(); i++) {
            System.out.print(aList.get(i) + " ");
        }
    }
}
