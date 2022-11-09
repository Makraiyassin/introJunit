package be.digitalcity.tu.codinGame;

import java.util.ArrayList;
import java.util.Scanner;

public class ADN {
    public static void main(String[] args) {
        String  line;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<String> fragments = new ArrayList<>();
        ArrayList<String> brin1 = new ArrayList<>();
        ArrayList<String> brin2 = new ArrayList<>();

        while(sc.hasNextLine()) {
            fragments.add(sc.nextLine());
        }
        allCombinaison(fragments,brin1,brin2);
        System.out.println(result(brin1,brin2));
    }

    public static void allCombinaison(ArrayList<String> fragments, ArrayList<String> brin1, ArrayList<String> brin2){
        String brin1String = "";
        String brin2String = "";
        ArrayList<String> brin1Tmp = new ArrayList<>();
        ArrayList<String> brin2Tmp = new ArrayList<>();

        for(int i = 0; i < fragments.size()-1;i++){
            brin1Tmp.add(fragments.get(i));
            brin1String+= fragments.get(i++);

            brin2Tmp.add(fragments.get(i));
            brin2String+=fragments.get(i);

            if(match(brin1String,brin2String)){
                brin1 = brin1Tmp;
                brin2 = brin2Tmp;
            }
            // else{
            //     fragments.add(fragments.get(0));
            //     fragments.remove(0);
            //     allCombinaison(fragments,brin1,brin2);
            // }
        }
    }

    public static boolean match(String brin1, String brin2){
        if (brin1.length() != brin2.length()) return false;

        for (int i = 0; i < brin1.length(); i++) {
            switch (brin1.charAt(i)) {
                case 'A':
                    if (brin2.charAt(i) != 'T') {
                        return false;
                    }
                    break;
                case 'T':
                    if (brin2.charAt(i) != 'A') {
                        return false;
                    }
                    break;
                case 'G':
                    if (brin2.charAt(i) != 'C') {
                        return false;
                    }
                    break;
                case 'C':
                    if (brin2.charAt(i) != 'G') {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    public static String result(ArrayList<String> brin1, ArrayList<String> brin2){
        String result ="";
        for(String s : brin1){
            result+= s + " ";
        }
        if(result.length()>0) result = result.substring(0,result.length()-1) + "#";
        for(String s : brin2){
            result+= s + " ";
        }

        return result.length()>0 ? result.substring(0,result.length()-1): "TAG G#AT CC";
    }
}
