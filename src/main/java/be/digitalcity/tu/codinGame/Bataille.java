package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class Bataille {
    public static void main(String[] args) {
        String  line;
        Scanner sc = new Scanner(System.in);
        int nombreTours = Integer.parseInt(sc.nextLine());
        int pointsA = 0;
        int pointsB = 0;

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(line.length() == 3){
                int a = Integer.parseInt(line.substring(0,1));
                int b = Integer.parseInt(line.substring(2,3));
                if(a>b) pointsA ++;
                else if (a < b) pointsB ++;
            }
        }
        System.out.println(pointsA>pointsB ? "A" : "B");
    }

}
