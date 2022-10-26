package be.digitalcity.tu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {
//        System.out.println(exist3(new int[]{1,2,3,56,58,632,56,4},56));
//        System.out.println(test2(new int[]{4,85,5,-4,-9,100,87}));
        System.out.println(test3());
        System.out.println(test4());
        System.out.println(test5());
        ArrayList<String > a = new ArrayList<>();

    }

       static boolean exist1(int[] ints, int k){
            if (Arrays.stream(ints).filter(n -> n == k).toArray().length>0)
                return true;
            return false;
       }
       static boolean exist2(int[] ints, int k){
            if (Arrays.stream(ints).anyMatch(n-> n == k))
                return true;
            return false;
       }
       static boolean exist3(int[] ints, int k){
            if(ints[0] == k) return true;
            else return Arrays.binarySearch(ints, k) > 0;
       }
       static int test2(int[] numbers){
           if(numbers.length<1){
               return 0;
           }

           int closest = 0;

           for (int i = 0; i < numbers.length ; i++) {
               if (closest == 0) {
                   closest = numbers[i];
               } else if (numbers[i] > 0 && numbers[i] <= Math.abs(closest)) {
                   closest = numbers[i];
               } else if (numbers[i] < 0 && - numbers[i] < Math.abs(closest)) {
                   closest = numbers[i];
               }
           }

           return closest;
       }


       static String test3(){

        return "";
       }

       static int test4(){


        return 0;
       }

       static int test5(){
        return 0;
       }
}
