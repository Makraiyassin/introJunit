package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class PrixLePlusBas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  line;
        int prixMin=Integer.MAX_VALUE;
        int nombreProduits = sc.nextInt();
        sc.nextLine();
        String produit = sc.nextLine();

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            if(line.indexOf(produit) != -1){
                int price = Integer.parseInt(line.substring(produit.length()+1));
                prixMin = price < prixMin ? price : prixMin;
            }
        }

        System.out.println(prixMin);
    }
}
