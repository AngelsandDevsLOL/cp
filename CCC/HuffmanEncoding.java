package CCC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanEncoding {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Map<String, String> map = new HashMap<String, String>();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String[] array = scanner.nextLine().split(" ");
            map.put(array[1], (array[0]));
            // I made the actual binary code go in the key value and the letter go in the value
        }
        String binarySequenceSTRING = scanner.nextLine();
        int start = 0;
        int keyLength = 1;
        StringBuilder sb = new StringBuilder();
        // This stringbuilder is to add all the letters for the binary code
        while (start < binarySequenceSTRING.length()) {
            String key = binarySequenceSTRING.substring(start, start + keyLength);
            // Because I don't know the length of the map values, I put keyLength because it has to be 1 or more.
            if (map.get(key) != null) {
                // this only runs after the first letter is found in the binary
                sb.append(map.get(key));
                // I add the letter to the stringbuilder
                start = start + keyLength;
                // I need to add keyLength to start because after I find the first letter, I need to move onto the other letters
                keyLength = 1;
                // if I don't put keyLength back to 1, then the next time this runs, start would be greater than it is supposed to be
            } else {
                keyLength++;
                // This happens if the map value is greater than keyLength, because keyLength would only grow to fit the length of the value
            }

        }
        System.out.println(sb.toString());
        // I printed the stringbuilder
    }
}
