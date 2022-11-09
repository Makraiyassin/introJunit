package be.digitalcity.tu.codinGame;

import java.util.Arrays;
import java.util.Scanner;

public class Hydroponie {
    public static void main(String[] args) {
        String [] line;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[][] ferme = new String[N][N];
        int nbrCaseCultivable = 0;

        for(int i = 0; i<N; i++){
            line = sc.nextLine().split("");
            for(int j = 0; j < N; j++){
                if(line[j].equals("X")){
                    ferme[i][j]="X";
                    if(i>0 && j>0)      ferme[i-1][j-1] = ferme[i-1][j-1] == null ? "OK" : ferme[i-1][j-1];
                    if(i<N-1 && j<N-1)  ferme[i+1][j+1] = ferme[i+1][j+1] == null ? "OK" : ferme[i+1][j+1];
                    if(i>0 && j<N-1)    ferme[i-1][j+1] = ferme[i-1][j+1] == null ? "OK" : ferme[i-1][j+1];
                    if(i<N-1 && j>0)    ferme[i+1][j-1] = ferme[i+1][j-1] == null ? "OK" : ferme[i+1][j-1];

                    if(i>0)     ferme[i-1][j] = ferme[i-1][j] == null ? "OK" : ferme[i-1][j];
                    if(j>0)     ferme[i][j-1] = ferme[i][j-1] == null ? "OK" : ferme[i][j-1];
                    if(i<N-1)   ferme[i+1][j] = ferme[i+1][j] == null ? "OK" : ferme[i+1][j];
                    if(j<N-1)   ferme[i][j+1] = ferme[i][j+1] == null ? "OK" : ferme[i][j+1];
                }
            }
        }

        for(String[] lineFerme : ferme){
            System.err.println("line: "+ Arrays.toString(lineFerme));
            for(String cellFerme : lineFerme){
                if(cellFerme != null && cellFerme.equals("OK")) nbrCaseCultivable ++;
            }
        }

        System.err.println("nbr: "+nbrCaseCultivable);
        System.out.println(nbrCaseCultivable);
    }
}
