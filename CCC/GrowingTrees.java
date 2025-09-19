package CCC;

import java.util.*;

public class GrowingTrees {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array2 = new int[n][2];
        int[] array3 = new int[n];
        int year = 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            int growth = scanner.nextInt();
            array2[i][0] = height;
            array2[i][1] = growth;
            array3[i] = height;
            hMap.put(height, growth);
        }
        Sort2DArrayBasedOnColumnNumber(array2, 2);
        Arrays.sort(array3);
        boolean bool = false;
        for (int i = 0; i < array3.length; i++) {
            if (array2[i][0] != array3[i] || hMap.size() != n){
                bool = true;
                break;
            }
        }
        if (bool) {
            while (bool) {
                if (hMap.size() != n) {
                    bool = false;
                } else {
                    Set<Integer> set = hMap.keySet();
                    Object[] array = set.toArray();
                    for (int j = 0; j < hMap.size(); j++) {
                        int height = Integer.parseInt(String.valueOf(array[j]));
                        int newheight = height + hMap.get(height);
                        hMap.put(newheight, hMap.get(height));
                        hMap.remove(height);
                    }
                    year++;
                }
            }
            System.out.println(year);
        } else
            System.out.println(-1);
    }
    public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[columnNumber-1] > second[columnNumber-1]) return 1;
                else return -1;
            }
        });
    }
}
