package be.digitalcity.tu;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String [] args) {
        System.out.println("========== regex ==========");
        System.out.println("BE69-  8601-0677  -75|78".replaceAll("[\\s-|]", ""));
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

        System.out.println("=========== Collections ============");

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,11,5,9,8,1));
        System.out.println(set.toString());
        System.out.println(set.toString());
        System.out.println(set.toString());

        Set<String> set2 = new HashSet<>();
        set2.add("one");
        set2.add("two");
        set2.add("three");

        List<String> listSet2 = new ArrayList<>(set2);
        System.out.println(listSet2.get(1));

        Integer[] fibonacci = {0,1,1,2,3,5,8,13,21,34,55};

        List<Integer> intList = Arrays.asList(fibonacci);
        Collections.shuffle(intList);
        intList.toArray(fibonacci);
        System.out.println(Arrays.toString(fibonacci));
//        Arrays.sort(fibonacci);

        System.out.println(Arrays.binarySearch(fibonacci,8));

        Set<Integer> treeSetFibonacci = new TreeSet<>(Arrays.asList(fibonacci));
        Set<Integer> hashSetFibonacci = new HashSet<>(Arrays.asList(fibonacci));
        System.out.println(treeSetFibonacci);
        System.out.println(hashSetFibonacci);

        System.out.println("================ Comparison array ==========");
        int[] array1 = {1,0,3,4,9,6,7};
        int[] array2 = {1,2,3,4,5,6,7};

        System.out.println(array1.equals(array2));
        System.out.println(Arrays.equals(array1,array2));
        System.out.println(Arrays.compare(array1,array2));
        System.out.println(Arrays.mismatch(array1,array2));

        System.out.println("================ args ==========");
        System.out.println(Arrays.toString(args));

        System.out.println("========= array multi =========");

        String[][][] multiArray = new String[3][5][4];
        for (String [][] multiAr : multiArray) {
            System.out.println(Arrays.toString(multiAr));

            for (String [] ar :multiAr) {
//                System.out.println(Arrays.toString(ar));
            }
        }

        String[][] westCoastCitiesGrouped = new String[][]{
                {"LA", "San Francisco", "San Diego"},
                {"Seattle", "Tacoma"},
                {"Portland"}
        };

        for (String [] ar : westCoastCitiesGrouped) {
            for (String word: ar) {
                System.out.println(word);
            }
        }



    }
    public static void someMethode(int... nums){
        System.out.println(Arrays.toString(nums));
    }
}
