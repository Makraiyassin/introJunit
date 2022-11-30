package be.digitalcity.tu.codinGame;

import java.util.*;

public class CertifJavaCodinGame {


    public static void main1(String args[]) {
        /**
         * input:
         *      4
         *      2 2 5 3
         * output: 1 2  (1 highJumps & 2 lowJumps)
         */


        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int highJumps = 0;
        int lowJumps = 0;
        int pillar = 0;
        for (int i = 0; i < N; i++) {
            int H = in.nextInt();
            if(i == 0) pillar = H;
            else{
                if(H > pillar) {
                    highJumps++;
                    pillar = H;
                }else{
                    lowJumps++;
                    pillar = H;
                }
            }
        }
        System.out.println(highJumps+" "+lowJumps);
    }

    public static void main2(String args[]) {
        //input: 2+4+3+1+5
        //output: 1+2+3+4+5

        Scanner in = new Scanner(System.in);
        String [] sum = in.next().split("\\+");
        Arrays.sort(sum);
        String answer = "";
        for(int i =0;i<sum.length; i++){
            answer+= sum[i]+"+";
        }
        System.out.println(answer.substring(0,answer.length()-1));
    }

    public static void main3(String args[]) {

        //input: $4.32
        //output: 4 1 0 1 2  (nombre de Dollars, quarters, dimes, nickels et pennies)

        Scanner in = new Scanner(System.in);
        String S = in.nextLine().replace("$", "");
        System.err.println(S);
        String beforeComa = S.split("\\.")[0];
        String afterComa = S.split("\\.")[1];
        int dollars = Integer.parseInt(beforeComa);
        int cents =  Integer.parseInt(afterComa);
        int quarter = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        quarter = cents/25;
        cents = cents%25;
        dimes = cents/10;
        cents = cents%10;
        nickels = cents/5;
        cents = cents%5;
        pennies = cents/1;

        System.out.println(dollars+" "+quarter+" "+dimes+" "+nickels+" "+pennies);
    }

    public static void main(String[] args) {

        /**
         * input:
         *      2
         *      1 3   => A B
         *      10 12 => A B
         * output:
         *      4   => sum de: pour chaque nombre entre A et B inclus s'il sont "deficients" : difference entre double du nombre et la sum de ses diviseur
         *      12
         *      ("deficients" designe les nombre dont la sum de ses diviseur est inférieur à son double)
         */

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][2];
        int answer;

        for (int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            answer = 0;
            for(int j = arr[i][0]; j <= arr[i][1];j++){
                ArrayList<Integer> divisors = new ArrayList<>();
                for(int k = 1; k<=j; k++){
                    if(j%k==0)divisors.add(k);
                }
                System.err.println(divisors);

                int sum =  divisors.stream().mapToInt(Integer::intValue).sum();

                System.err.println(sum);

                if( sum < j*2 ){
                    answer += (j*2)-sum;
                }
            }

            System.out.println(answer);
        }
    }

    public static void main5(String[] args) {
        System.out.println("Arza1208".matches("[A-Za-z1-9]+"));
    }
}
