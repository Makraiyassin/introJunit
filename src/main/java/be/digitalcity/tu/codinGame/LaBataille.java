package be.digitalcity.tu.codinGame;

import java.util.*;

public class LaBataille {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Character> strength = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A'));
        List<String> cardsPl1 = new ArrayList<>();
        List<String> cardsPl2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            cardsPl1.add(0,in.next());
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            cardsPl2.add(0,in.next());
        }

        while(cardsPl1.size()>0 && cardsPl2.size()>0){
            String cardP1 = cardsPl1.remove(cardsPl1.size()-1);
            String cardP2 = cardsPl2.remove(cardsPl2.size()-1);
            if( strength.indexOf( cardP1.charAt(0) ) > strength.indexOf( cardP2.charAt(0) )){
                cardsPl1.add(0, cardP1);
                cardsPl1.add(0, cardP2);
                count++;
            }
            else if( strength.indexOf( cardP1.charAt(0) ) < strength.indexOf( cardP2.charAt(0) )){
                cardsPl2.add(0, cardP1);
                cardsPl2.add(0, cardP2);
                count++;
            }
            else if( strength.indexOf( cardP1.charAt(0) ) == strength.indexOf( cardP2.charAt(0) )){
                for(int i =0; i<3; i++){
                    if(cardsPl1.size()==0 && cardsPl2.size()==0 ) break;
                    else if(cardsPl1.size()==0 && cardsPl2.size()!=0 ) cardsPl2.remove(cardsPl2.size()-1);
                    else if(cardsPl1.size()!=0 && cardsPl2.size()==0 ) cardsPl1.remove(cardsPl1.size()-1);
                    else{
                        cardsPl1.remove(cardsPl1.size()-1);
                        cardsPl2.remove(cardsPl2.size()-1);
                    }
                }
            }
        }
        if(cardsPl1.size()>0 ) System.out.println("1 "+count);
        else if(cardsPl2.size()>0 ) System.out.println("2 "+count);
        else System.out.println("PAT");
    }
}
