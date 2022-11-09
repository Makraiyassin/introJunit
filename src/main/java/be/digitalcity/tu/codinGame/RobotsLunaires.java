package be.digitalcity.tu.codinGame;

import java.util.Scanner;

public class RobotsLunaires {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] maxCoordinate = new int[]{sc.nextInt(), sc.nextInt()};
        sc.nextLine();

        String departRobot;
        String[] instructions;

        while(sc.hasNextLine()) {
            // departRobot 1 2 N
            int xRobot = sc.nextInt();
            int yRobot = sc.nextInt();
            String directionRobot = sc.nextLine().substring(1);
            instructions = sc.nextLine().split("");// LMLMLMLMM

            for(String instruction:instructions){
                switch(instruction){
                    case "L":
                        if(directionRobot.equals("N")) directionRobot = "W";
                        else if(directionRobot.equals("W")) directionRobot = "S";
                        else if(directionRobot.equals("S")) directionRobot = "E";
                        else if(directionRobot.equals("E")) directionRobot = "N";
                        break;
                    case "R":
                        if(directionRobot.equals("N")) directionRobot = "E";
                        else if(directionRobot.equals("E")) directionRobot = "S";
                        else if(directionRobot.equals("S")) directionRobot = "W";
                        else if(directionRobot.equals("W")) directionRobot = "N";
                        break;
                    case "M":
                        if(directionRobot.equals("N")) yRobot++;
                        else if(directionRobot.equals("E")) xRobot++;
                        else if(directionRobot.equals("S")) yRobot--;
                        else if(directionRobot.equals("W")) xRobot--;
                        break;
                }
            }
            System.out.println(xRobot + " " + yRobot + " " + directionRobot);
        }
    }
}
