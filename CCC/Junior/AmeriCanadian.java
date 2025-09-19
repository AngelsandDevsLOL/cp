package CCC.Junior;

import java.util.ArrayList;
import java.util.Scanner;

public class AmeriCanadian {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<String>();
        String x = scanner.nextLine();
        while (!(x.equals("quit!"))) {
            array.add(x);
            x = scanner.nextLine();
        }
        int size = array.size();
        for (int i = 0; i < size; i++) {
            int integer = array.get(i).length() - 2;
            int integer2 = array.get(i).length();
            int integer3 = array.get(i).length()-3;
            if (array.get(i).length() > 4 && array.get(i).substring(integer, integer2).equals("or") && !(array.get(i).substring(integer3,integer).equals("a")) && !(array.get(i).substring(integer3,integer).equals("e")) && !(array.get(i).substring(integer3,integer).equals("i")) && !(array.get(i).substring(integer3,integer).equals("o")) && !(array.get(i).substring(integer3,integer).equals("u")) && !(array.get(i).substring(integer3,integer).equals("y"))){
                String var = array.get(i).substring(0,integer);
                array.add(var+"our");
            } else
                array.add(array.get(i));
        }
        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i+size));
        }
    }
}
