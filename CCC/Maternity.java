package CCC;

import java.util.Scanner;

public class Maternity {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String mother = scanner.nextLine();
        String father = scanner.nextLine();
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            String baby = scanner.nextLine();
            boolean bool = true;
            for (int j = 0; j < baby.length(); j++) {
                String x = (baby.substring(j,j+1));
                if (x.toLowerCase().equals(x)){
                    if (!(mother.contains(x) && father.contains(x))){
                        bool = false;
                        break;
                    }
                } else {
                    if (!(mother.contains(baby.substring(j, j + 1)) || father.contains(baby.substring(j, j + 1)))) {
                        bool = false;
                        break;
                    }
                }
            }
            if (bool){
                System.out.println("Possible baby.");
            } else
                System.out.println("Not their baby!");
        }
    }
}
