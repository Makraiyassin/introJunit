package be.digitalcity.tu;

import java.util.Arrays;

public class TestCodility2 {
    public static void main(String[] args) {
        System.out.println(solution(512,10)); // 972
//        System.out.println(solution2("ZZXYOz","OOYXZZ")); // 2
//        System.out.println(solution2("zzzX","zzzX")); // 10
    }

    public static int solution(int N, int K) {
        String n = Integer.toString(N);
        int[] arr = new int[n.length()];
        int result = 0;

        for (int i = 0; i < n.length(); i++)
        {
            arr[i] = n.charAt(i) - '0'; //or - 48
            System.out.println("test1: "+n.charAt(i));
            System.out.println("test2: "+ (n.charAt(i)-'0'));
            System.out.println("test3: "+ (n.charAt(i)-48));
            System.out.println();
        }

        for (int j = 0; j < arr.length; j++) {
            while (K>0){
                if (result == 999) return result;
                if (arr[j] == 9) break;
                arr[j] += 1;
                K--;

                String tmp = "";

                for(int number : arr){
                    tmp+=number;
                }

                result = Integer.parseInt(tmp);
            }
        }

        return result;
    }

    public static int solution2(String A, String B) {

        int total = 0;

        for (int i = 0; i<A.length(); i++){
            if (A.charAt(i) == B.charAt(i)) {
                total ++;
            }
        }

        for (int i = 0; i<A.length(); i++){
            String tmpA = A.substring(i,A.length());
            String tmpB = B.substring(i,B.length());

            for (int j = 0; j < tmpA.length(); j++) {
                String[] arrA = tmpA.split("");
                String[] arrB = tmpB.split("");
//                if(arrA.length == 1) break;

                Arrays.sort(arrA);
                Arrays.sort(arrB);
                if(Arrays.equals(arrA,arrB)) total++;

                tmpA = tmpA.substring(0,tmpA.length()-1);
                tmpB = tmpB.substring(0,tmpB.length()-1);
            }

        }
        return total;
    }
}
