package CCC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Jerseys {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int amountOfJersey = scanner.nextInt();
        int numberOfAthletes = scanner.nextInt();
        HashMap<Integer, String> hMap = new HashMap();

        String[] jerseySizes = new String[amountOfJersey];
        scanner.nextLine();
        for (int i = 0; i < amountOfJersey; i++) {
            jerseySizes[i] = scanner.nextLine();
            hMap.put(i,jerseySizes[i]);
        }
        String[] jerseyRequest = new String[numberOfAthletes];
        for (int i = 0; i < numberOfAthletes; i++) {
            jerseyRequest[i] = scanner.nextLine();
        }
        int requests = 0;
        for (int i = 0; i < numberOfAthletes; i++) {
            String[] input = jerseyRequest[i].split(" ");
            int number = Integer.parseInt(input[1])-1;
            String size = input[0];
            if (hMap.containsKey(number)){
                if (size.equals("M")){
                    if (hMap.get(number).equals("M") || hMap.get(number).equals("L")){
                        requests++;
                        hMap.remove(number);
                    }
                } else if (size.equals("L")){
                    if (hMap.get(number).equals("L")){
                        requests++;
                        hMap.remove(number);
                    }
                } else if (size.equals("S")) {
                    requests++;
                    hMap.remove(number);
                }
            }
        }
        System.out.println(requests);
    }
}