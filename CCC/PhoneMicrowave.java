package CCC;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhoneMicrowave {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        scanner.nextLine();
        String timeString=scanner.nextLine();

        int year = (Integer.parseInt(timeString.substring(0,4)));
        int month = (Integer.parseInt(timeString.substring(5,7)));
        int day = Integer.parseInt(timeString.substring(8,10));
        int hour = Integer.parseInt(timeString.substring(11,13));
        int minute = Integer.parseInt(timeString.substring(14,16));
        int second = Integer.parseInt(timeString.substring(17,19));
        LocalDateTime microWaveTime=  LocalDateTime.of(year,month,day,hour,minute,second);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(formatter.format( microWaveTime.minusHours(s)));


    }
}
