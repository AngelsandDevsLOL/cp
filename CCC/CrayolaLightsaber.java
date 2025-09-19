package CCC;


import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import java.util.Scanner;

public class CrayolaLightsaber {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        Map<String, Integer> hmap = new HashMap<>();
        // System.out.print(""+n+" ");
        for (int i = 0; i < n; i++) {
            //  System.out.print(" "+input[i]);
            int value=1;
            if (hmap.get(input[i])!=null){
                value=hmap.get(input[i])+1;
            }
            hmap.put(input[i],value);

        }
        int length=0;
        String lastColor=null;
        while (hmap.size()>0) {
            String[] keys= sortByValue(hmap);
            if (keys.length==1) {
                if (!keys[0].equals(lastColor)) {
                    length++;
                }
                break;
            }
            int pair=hmap.get(keys[keys.length-2]);
            length=length+pair*2;
            lastColor=keys[keys.length-2];
            hmap.remove(lastColor);
            int left=hmap.get(keys[keys.length-1]) - pair;
            if (left==0) {
                hmap.remove(keys[keys.length-1]);
            }else {
                hmap.put(keys[keys.length-1],left);
            }
        }
        System.out.println(length);
    }


    private static String[] sortByValue(Map<String, Integer> map){
        return map.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new)).keySet().toArray(new String[0]);
    }
}
