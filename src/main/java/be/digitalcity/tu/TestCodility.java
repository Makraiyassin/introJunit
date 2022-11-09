package be.digitalcity.tu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCodility {
    public static void main(String[] args) {
        System.out.println(new int[] {} == null);
        /**
         * Question 1: Returns if two strings are equal.
         */
//        System.out.println(isEqual("abc", "abc"));
//        System.out.println(isEqual("carp", "cart"));
//        System.out.println(isEqual("pool", "tool"));
//        System.out.println(isEqual("jasmine", "jasm"));

        /**
         * Question 2: Returns the index at which 2 strings are unequal. Otherwise returns
         * -1.
         */
//        System.out.println(indexOfDeviation("abc", "abd"));
//        System.out.println(indexOfDeviation("abcd", "abc"));
//        System.out.println(indexOfDeviation("xyz", "123"));
//        System.out.println(indexOfDeviation("abc", "abc"));
//        System.out.println(indexOfDeviation("qwerty", "qwertp"));
//        System.out.println(indexOfDeviation("t", "p"));
//        System.out.println(indexOfDeviation("heplo", "hello"));
//        System.out.println(indexOfDeviation("earth_mars_pluto", "earth_mars"));
//        System.out.println(indexOfDeviation("earth_mars", "earth_mars_pluto"));
//        System.out.println(indexOfDeviation("abc", null));
//        System.out.println(indexOfDeviation(null, "abc"));
//        System.out.println(indexOfDeviation("", "abc"));
//        System.out.println(indexOfDeviation("abc", ""));

        /**
         * Question 3: Return a comma delimited, alphanumerically sorted, string of all the
         * common characters between two strings. Repeat characters do not need to be
         * included.
         */
//        System.out.println(string_contains("ae", "elephant"));
//        System.out.println(string_contains("car", "race"));
//        System.out.println(string_contains("piano", "gruel"));
//        System.out.println(string_contains("abc25", "abcd5"));
//        System.out.println(string_contains("aeiou", "carolina"));
//        System.out.println(string_contains("zx", "xxxxyyxxz"));
//        System.out.println(string_contains("xyz", null));
//        System.out.println(string_contains("xyz", ""));

        /**
         * Question 4: Create a method that given an array of words returns a new array with
         * only the words that contain all the letters from a string.
         */
//        System.out.println(Arrays.toString(string_contains2(new String[]{"chicken", "cow", "horse", "whale", "elephant"}, "ae")));

        /**
         * Question 5: Given a list with the mean temperature per day,
         * find the longest consecutive sequence of days
         * where the temperature stays within five degrees.
         * In other words the maximum temperature
         * within the sequence minus the minimum temperature
         * within the sequence must not be greater than five.
         * All mean temperatures have integer values.
         */

        /**
         * 5.a: Length of the Longest consecutive subsequence
         */
        System.out.println(findLongestConseqSubseq(new int[]{1, 9, 3, 10, 4, 20, 2}));
        System.out.println(findLongestConseqSubseq(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));

        /**
         * 5.b: return start day for the longest sequence of days where the mean temperature ( within five degrees).
         */
        //TODO : INCORRECT
//        System.out.println(getStartDay(new int[]{11, 2, 11, 9, 9, 12, 5, 6, 3, 11, 12, 4, 3, 3, 4, 8, 4, 8, 9, 5, 6, 12, 4}));

         /**
         * 5.c: return end day for the longest sequence of days where the mean temperature ( within five degrees).
         * Note: that the start and end day of the sequence may be the same.
         * */
        //TODO : INCORRECT

    }

    private static  boolean isEqual(String str2, String str1) {
        return str2.equals(str1);
    }
    private static  int indexOfDeviation(String str2, String str1) {
        if (str2 == null || str1 == null)
            return 0;
        if (str2.isEmpty() || str1.isEmpty())
            return 0;
        if (str1.equals(str2))
            return -1;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != str1.charAt(i))
                return i;
            if (str2.length() > str1.length() && i == str1.length() - 1)
                return i + 1;
            if (str2.length() < str1.length() && i == str2.length() - 1) {
                return i + 1;
            }
        }
        return -1;
    }
    private static  String string_contains(String str2, String str1) {
        Set<String> result = new TreeSet<>();

        if (str2 == null || str1 == null)
            return "";
        if (str2.isEmpty() || str1.isEmpty())
            return "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j))
                    result.add(""+str1.charAt(i));
            }
        }
        return result.stream().collect(Collectors.joining(", "));
    }
    private static  String[] string_contains2(String[] words, String letters) {
        List<String> resultList = new ArrayList<>();
        for (String word : words){
            boolean containsAll = false;
            for (int i = 0; i<letters.length(); i++){
                if(word.indexOf(letters.charAt(i)) != -1) containsAll = true;
                else {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) resultList.add(word);
        }
        String[] resultArray = new String[resultList.size()];
        return resultList.toArray(resultArray);
    }

    public static int findLongestConseqSubseq(int[] arr) {

        int answer = 0, count = 0;

        Arrays.sort(arr);
        ArrayList<Integer> vector = new ArrayList<Integer>();
        vector.add(arr[0]);

        // Insert repeated elements
        // only once in the vector
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1])
                vector.add(arr[i]);
        }

        // Find the maximum length
        // by traversing the array
        for (int i = 0; i < vector.size(); i++) {

            // Check if the current element is
            // equal to previous element +1
            if (i > 0 && vector.get(i) == vector.get(i - 1) + 1)
                count++;
            else
                count = 1;

            // Update the maximum
            answer = Math.max(answer, count);
        }
        return answer;
    }
    public static int getStartDay(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum_so_far = 0;

            // consider all sub-arrays starting from i and ending at j
            for (int j = i; j < arr.length; j++) {
                // sum of elements so far
                sum_so_far += arr[j];

                // if sum so far is equal to the given sum
                if (sum_so_far == 5) {
                    System.out.println();
                }
            }
        }
        return 0;
    }
    public static int getEndDay(int[] arr) {
        return 0;
    }




}
