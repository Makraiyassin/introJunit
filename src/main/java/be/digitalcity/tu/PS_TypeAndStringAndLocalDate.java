package be.digitalcity.tu;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PS_TypeAndStringAndLocalDate {
    public static void main(String [] args) {

        System.out.println("========== regex ==========");
        System.out.println("BE69-  8601-0677  -75|78".replaceAll("[\\s-|]", ""));

        System.out.println("========== DateTime ... ==========");
        DateTimeFormatter tzFormat = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
        LocalDateTime dateofFlight = LocalDateTime.of(2015, Month.AUGUST, 30, 15, 30);
        ZoneId ziDeparture = ZoneId.of("America/Chicago");
        ZonedDateTime dtDeparture =  ZonedDateTime.of(dateofFlight, ziDeparture);
        String dateDisplay1 = dtDeparture.format(tzFormat);
        System.out.printf("DEPARTURE: %s (%s)\n", dateDisplay1, ziDeparture);
        ZoneId ziArrival = ZoneId.of("Asia/Tokyo");
        ZonedDateTime dtArrival = dtDeparture.withZoneSameInstant(ziArrival).plusMinutes(1140);
        String dateDisplay2 = dtArrival.format(tzFormat);
        System.out.printf("ARRIVAL: %s (%s)",dateDisplay2, ziArrival);

        System.out.println("======== var ============");
        var variable2 = Arrays.asList(1,2,3)  ;
        System.out.println(variable2.toString());

        System.out.println("========= int... nums ===========");
        int[] array = {1,2,3,4};
        someMethode(array);
        someMethode(1,2,3,4);

        System.out.println("========== String pool ==========");
        String  str = "hello world!";
        String str2 = "hello world!";
        System.out.println(str == str2);//true

        String str3 = new String("hello world!");
        System.out.println(str == str3);//false

        String str4 = str.substring(6);
        String str5 = str.substring(6);

        System.out.println(str4 + " "+ str5);

        System.out.println(str4 == str5); //false
        System.out.println(str4.equals(str5)); //true

        System.out.println("======== index of =========");
        System.out.println("hello".indexOf("co"));

        System.out.println("======== localDate =========");
        System.out.println(LocalDate.of(2022, Month.AUGUST,10));
        System.out.println(LocalDate.of(2022, 8,10));
        System.out.println(LocalTime.of(10,30));
        System.out.println(LocalTime.of(10,30,0,0));
        System.out.println(LocalDateTime.of(2022, 8,10,10,30));

        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2022,
                8,
                10,
                10,30,
                0,
                0,
                ZoneId.of("America/Chicago")
        );
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("EEEE '(jour/semaine)',dd '(jour/mois)', MM '(mois)',yyyy '(annee)' ")));


    }
    public static void someMethode(int... nums){
        System.out.println(Arrays.toString(nums));
    }
}
