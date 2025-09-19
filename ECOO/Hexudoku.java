package ECOO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hexudoku {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> hMap = new HashMap();
        hMap.put(1, "0");
        hMap.put(2, "1");
        hMap.put(3, "2");
        hMap.put(4, "3");
        hMap.put(5, "4");
        hMap.put(6, "5");
        hMap.put(7, "6");
        hMap.put(8, "7");
        hMap.put(9, "8");
        hMap.put(10, "9");
        hMap.put(11, "A");
        hMap.put(12, "B");
        hMap.put(13, "C");
        hMap.put(14, "D");
        hMap.put(15, "E");
        hMap.put(16, "F");
        for (int i = 0; i < 10; i++) {
            String[] ar = new String[16];
            HashMap<Integer, ArrayList<String>> rows = new HashMap<Integer, ArrayList<String>>();
            HashMap<Integer, ArrayList<String>> columns = new HashMap<Integer, ArrayList<String>>();
            HashMap<Integer, ArrayList<String>> quadrants = new HashMap<Integer, ArrayList<String>>();
            int sum = 0;
            for (int j = 0; j < 16; j++) {
                ar[j] = scanner.nextLine();
                for (int k = 0; k < 16; k++) {
                    if (!(ar[j].substring(k,k+1).equals("-"))) {
                        if (rows.containsKey(j)) {
                            rows.get(j).add(ar[j].substring(k,k+1));
                        } else {
                            ArrayList<String> aList = new ArrayList<>();
                            aList.add(ar[j].substring(k,k+1));
                            rows.put(j, aList);
                        }
                        if (columns.containsKey(k)) {
                            columns.get(k).add(ar[j].substring(k,k+1));
                        } else {
                            ArrayList<String> aList = new ArrayList<>();
                            aList.add(ar[j].substring(k,k+1));
                            columns.put(k, aList);
                        }
                        int qnum = quadrantnum(j, k)-1;
                        if (quadrants.containsKey(qnum)) {
                            quadrants.get(qnum).add(ar[j].substring(k,k+1));
                        } else {
                            ArrayList<String> aList = new ArrayList<>();
                            aList.add(ar[j].substring(k,k+1));
                            quadrants.put(qnum, aList);
                        }
                    }
                }
            }
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    if (ar[j].substring(k,k+1).equals("-")) {
                        for (int l = 1; l <= 16; l++) {
                            ArrayList<String> row = rows.get(j);
                            ArrayList<String> column = columns.get(k);
                            int qnum = quadrantnum(j, k)-1;
                            ArrayList<String> quadrant = quadrants.get(qnum);
                            if (row == null) {
                                row = new ArrayList<>();
                            }
                            if (column == null) {
                                column = new ArrayList<>();
                            }
                            if (quadrant == null) {
                                quadrant =new ArrayList<>();
                            }
                            if ((!row.contains(hMap.get(l))) && (!column.contains(hMap.get(l))) && !quadrant.contains(hMap.get(l))) {
                                ar[j] = ar[j].substring(0, k) + hMap.get(l) + ar[j].substring(k+1);
                                row.add(hMap.get(l));
                                quadrant.add(hMap.get(l));
                                column.add(hMap.get(l));
                                rows.put(j, row);
                                quadrants.put(qnum, quadrant);
                                columns.put(k, column);
                                sum++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
    public static int quadrantnum (int r, int c) {
        if (r <= 3 && c <= 3) return 1;
        else if (r <= 3 && c <= 7) return 2;
        else if (r <= 3 && c <= 11) return 3;
        else if (r <= 3 && c <= 15) return 4;
        else if (r <= 7 && c <= 3) return 5;
        else if (r <= 7 && c <= 7) return 6;
        else if (r <= 7 && c <= 11) return 7;
        else if (r <= 7 && c <= 15) return 8;
        else if (r <= 11 && c <= 3) return 9;
        else if (r <= 11 && c <= 7) return 10;
        else if (r <= 11 && c <= 11) return 11;
        else if (r <= 11 && c <= 15) return 12;
        else if (r <= 15 && c <= 3) return 13;
        else if (r <= 15 && c <= 7) return 14;
        else if (r <= 15 && c <= 11) return 15;
        else return 16;
    }
}
