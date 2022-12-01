package be.digitalcity.tu.codinGame;
import java.util.*;
public class TheFall {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        int [][] grid = new int[H][W];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < H; i++) {
            String[] LINE = in.nextLine().split(" ");
            for(int j = 0; j< LINE.length; j++){
                grid[i][j] = Integer.parseInt(LINE[j]);
            }
        }
        int EX = in.nextInt();
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            switch(grid[YI][XI]){
                case 1:
                case 3:
                case 7:
                case 8:
                case 9:
                case 12:
                case 13:
                    System.out.println(XI+" "+(YI+1));
                    break;
                case 2:
                case 6:
                    if(POS.equals("RIGHT")) System.out.println((XI-1)+" "+YI);
                    else if(POS.equals("LEFT")) System.out.println((XI+1)+" "+YI);
                    break;
                case 4:
                case 10:
                    if(POS.equals("TOP")) System.out.println((XI-1)+" "+YI);
                    else if(POS.equals("RIGHT")) System.out.println(XI+" "+(YI+1));
                    break;
                case 5:
                case 11:
                    if(POS.equals("TOP")) System.out.println((XI+1)+" "+YI);
                    else if(POS.equals("LEFT")) System.out.println(XI+" "+(YI+1));
                    break;
                default:
                    break;
            }
        }
    }
}
