package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class TheDescent {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int [] mountains = new int[8];
        while (true) {
            for (int i = 0; i < 8; i++) {
                mountains[i] = in.nextInt();
            }
            int indexH = 0;
            for (int i = 0; i < mountains.length; i++) {
                indexH = mountains[i] > mountains[indexH] ? i : indexH;
            }
            System.out.println(indexH);
        }
    }
}
