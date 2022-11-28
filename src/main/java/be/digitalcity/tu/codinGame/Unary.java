package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class Unary {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String binaryMessage = "";
        String result = "";

        for(int i = 0; i < MESSAGE.length(); i++ ){
            System.err.println(MESSAGE.charAt(i));
            System.err.println(Integer.toBinaryString(MESSAGE.charAt(i)));
            binaryMessage+= Integer.toBinaryString(MESSAGE.charAt(i));
        }

        for(int j = 0; j<binaryMessage.length(); ){
            if(binaryMessage.charAt(j) == '1'){
                result += "0 ";
                while(binaryMessage.charAt(j) == '1'){
                    result += "0";
                    if(j==binaryMessage.length()-1) break;
                    j++;
                }
                result += " ";
            }
            else{
                result += "00 ";
                while(binaryMessage.charAt(j) == '0'){
                    result += "0";
                    if(j==binaryMessage.length()-1) break;
                    j++;

                }
                result += " ";
            }

            if(j==binaryMessage.length()-1){
                result = result.substring(0,result.length()-1);
                break;
            }
        }



        System.out.println(result);
    }
}
