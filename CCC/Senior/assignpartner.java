package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class assignpartner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int names = scanner.nextInt();
        scanner.nextLine();
        String result = "good";
        String array1[] = scanner.nextLine().split(" ");
        String array2[] = scanner.nextLine().split(" ");
        for (int i = 0; i < names; i++) {
            if (array1[i] == array2[i]) {
                result = "bad";
                break;
            }
            int nameIndex = Arrays.binarySearch(array1, array2[i]);
            if (nameIndex<0 || !array1[i].equals(array2[nameIndex])){
                result = "bad";
                break;
            }

        }
        System.out.println(result);
    }
}