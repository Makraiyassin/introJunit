package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class PowerOfThor {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt();
        int lightY = in.nextInt();
        int initialTx = in.nextInt();
        int initialTy = in.nextInt();
        while (true) {
            int remainingTurns = in.nextInt();
            if(lightX > initialTx && lightY < initialTy){
                System.out.println("NE");
                initialTx++; initialTy--;
            }
            else if(lightY < initialTy && lightX < initialTx) {
                System.out.println("NW");
                initialTx--; initialTy--;
            }
            else if(lightY > initialTy && lightX > initialTx) {
                System.out.println("SE");
                initialTx++; initialTy++;
            }
            else if(lightX < initialTx && lightY > initialTy) {
                System.out.println("SW");
                initialTx--; initialTy++;
            }
            else if(lightX > initialTx) {
                System.out.println("E");
                initialTx++;
            }
            else if(lightX < initialTx) {
                System.out.println("W");
                initialTx--;
            }
            else if(lightY > initialTy) {
                System.out.println("S");
                initialTy++;
            }
            else if(lightY < initialTy) {
                System.out.println("N");
                initialTy--;
            }
        }
    }
}
