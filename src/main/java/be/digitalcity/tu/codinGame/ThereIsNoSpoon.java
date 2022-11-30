package be.digitalcity.tu.codinGame;
import java.util.Scanner;
public class ThereIsNoSpoon {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        String [][] grid = new String[height][width];
        if (in.hasNextLine()) in.nextLine();
        for (int i = 0; i < height; i++) grid[i]= in.nextLine().split("");
        for(int y = 0; y<grid.length;y++){
            for(int x=0; x<grid[y].length; x++){
                String answerP1 = "";
                String answerP2 = "-1 -1";
                String answerP3 = "-1 -1";
                if(grid[y][x].equals("0")){
                    answerP1= x+ " "+y;
                    for(int i = x+1; i <grid[y].length ; i++){
                        if(grid[y][i].equals("0")){
                            answerP2= i+ " "+y;
                            break;
                        }
                    }
                    for(int i = y+1; i <grid.length ; i++){
                        if(grid[i][x].equals("0")) {
                            answerP3 = x+ " "+i;
                            break;
                        }
                    }
                    System.out.println(answerP1+" "+answerP2+" "+answerP3);
                }
            }
        }
    }
}
