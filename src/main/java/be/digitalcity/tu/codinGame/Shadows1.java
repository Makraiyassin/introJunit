package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class Shadows1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int N = in.nextInt();
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int minX = 0, maxX = W, minY = 0, maxY = H;
        while (true) {
            String bombDir = in.next();
            if(bombDir.equals("UR")) {
                maxY = Y0 -1;
                Y0 = (minY + maxY) / 2;
                minX = X0 + 1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("UL")) {
                maxY = Y0 -1;
                Y0 = (minY + maxY) / 2;
                maxX = X0 -1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("DR")) {
                minY = Y0 + 1;
                Y0 = (minY + maxY) / 2;
                minX = X0 + 1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("DL")){
                minY = Y0 + 1;
                Y0 = (minY + maxY) / 2;
                maxX = X0 -1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("U"))  {
                maxY = Y0 - 1;
                Y0 = (minY + maxY) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("D")) {
                minY = Y0 + 1;
                Y0 = (minY + maxY) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("R")) {
                minX = X0 + 1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
            else if(bombDir.equals("L"))  {
                maxX = X0 -1;
                X0 = (minX + maxX) / 2;
                System.out.println(X0 +" "+ Y0);
            }
        }
    }
}
