package be.digitalcity.tu.codinGame;

import java.util.*;

public class CodeRoyal {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numSites = in.nextInt();

        Map<Integer,Map<String,Integer>> allSites = new HashMap<>();
        int moveTo = -1;

        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            Map<String,Integer> tmpMap = new HashMap<>();
            tmpMap.put("x", x);
            tmpMap.put("y", y);
            tmpMap.put("radius", radius);
            tmpMap.put("owner", -1);
            tmpMap.put("structureType", -1);
            tmpMap.put("barrack", -1); //0 KNIGHT - 1 ARCHER
            allSites.put(siteId, tmpMap);
        }

        // game loop
        while (true) {
            int gold = in.nextInt();
            int touchedSite = in.nextInt(); // -1 if none

            for (int i = 0; i < numSites; i++) {
                int siteId = in.nextInt();
                int ignore1 = in.nextInt(); // used in future leagues
                int ignore2 = in.nextInt(); // used in future leagues
                int structureType = in.nextInt(); // -1 = No structure, 2 = Barracks
                int owner = in.nextInt(); // -1 = No structure, 0 = Friendly, 1 = Enemy
                int param1 = in.nextInt();
                int param2 = in.nextInt();

                allSites.get(siteId).put("owner", owner);
                allSites.get(siteId).put("structureType", structureType);
                if(moveTo == -1) moveTo = siteId;
            }

            int numUnits = in.nextInt();
            int archers = 0;
            int knights = 0;

            for (int i = 0; i < numUnits; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int owner = in.nextInt();
                int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
                int health = in.nextInt();

                if(owner == 0 && unitType == 0) knights++;
                else if(owner == 0 && unitType == 1) archers++;
            }

            if(touchedSite == -1){
                if(allSites.get(moveTo).get("structureType") == -1){
                    System.out.println("MOVE "+allSites.get(moveTo).get("x")+ " "+allSites.get(moveTo).get("y"));
                    allSites.get(moveTo).put("structureType",2);
                }
                else   System.out.println("MOVE "+allSites.get(moveTo).get("x")+ " "+allSites.get(moveTo).get("y"));
            }
            else if(allSites.get(touchedSite).get("barrack") == -1){
                System.out.println("BUILD "+touchedSite+ " BARRACKS-ARCHER");
                allSites.get(touchedSite).put("barrack",1);
            }
            else if(allSites.get(touchedSite).get("barrack") == 1 && archers >= 4){
                System.out.println("BUILD "+touchedSite+ " BARRACKS-KNIGHT");
                allSites.get(touchedSite).put("barrack",0);
                System.out.println("TRAIN");
                continue;
            }
            else if(allSites.get(touchedSite).get("barrack") == 0 && archers < 4){
                System.out.println("BUILD "+touchedSite+ " BARRACKS-ARCHER");
                allSites.get(touchedSite).put("barrack",1);
                System.out.println("TRAIN");
                continue;                    }
            else{
                System.err.println(allSites.get(touchedSite).get("barrack") );
                System.out.println("WAIT");
            }

            if(touchedSite != -1 && allSites.get(touchedSite).get("barrack") != -1)
                System.out.println("TRAIN "+touchedSite);
            else System.out.println("TRAIN");


            // First line: A valid queen action
            // Second line: A set of training instructions
        }
    }

//    public static void main2(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int numSites = in.nextInt();
//
//        List<Map<String,Integer>> allSites = new ArrayList<>();
//        int[] queenCoord = new int[]{0,0};
//
//        for (int i = 0; i < numSites; i++) {
//            int siteId = in.nextInt();
//            int x = in.nextInt();
//            int y = in.nextInt();
//            int radius = in.nextInt();
//            Map<String,Integer> tmpMap = new HashMap<>();
//            tmpMap.put("id", siteId);
//            tmpMap.put("x", x);
//            tmpMap.put("y", y);
//            tmpMap.put("radius", radius);
//            tmpMap.put("owner", -1);
//            tmpMap.put("structureType", -1);
//            tmpMap.put("unitTypeOrRadiusTower", -1); //0 KNIGHT - 1 ARCHER
//            allSites.add(tmpMap);
//        }
//
//        // game loop
//        while (true) {
//            int gold = in.nextInt();
//            int touchedSite = in.nextInt(); // -1 if none
//
//            for (int i = 0; i < numSites; i++) {
//                int siteId = in.nextInt();
//                int ignore1 = in.nextInt(); // used in future leagues
//                int ignore2 = in.nextInt(); // used in future leagues
//                int structureType = in.nextInt(); // -1 = No structure, 2 = Barracks
//                int owner = in.nextInt(); // -1 = No structure, 0 = Friendly, 1 = Enemy
//                int param1 = in.nextInt();
//                int param2 = in.nextInt();
//
//                allSites.stream().filter(site->site.get("id") == siteId).findFirst().ifPresent(
//                        site->{
//                            site.put("owner",owner);
//                            site.put("structureType", structureType);
//                            site.put("param1", param1);
//                            site.put("unitTypeOrRadiusTower", param2); //0 KNIGHT - 1 ARCHER
//                        }
//                );
//            }
//
//            int numUnits = in.nextInt();
//
//            int archers = 0;
//            int knights = 0;
//
//            for (int i = 0; i < numUnits; i++) {
//                int x = in.nextInt();
//                int y = in.nextInt();
//                int owner = in.nextInt();
//                int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
//                int health = in.nextInt();
//
//                if(owner == 0 && unitType == 0) knights++;
//                else if(owner == 0 && unitType == 1) archers++;
//
//                if(unitType == -1) {
//                    queenCoord[0] = x;
//                    queenCoord[1] = y;
//                }
//            }
//
//            if(touchedSite == -1){
//
//                // if(allSites.get(moveTo).get("structureType") == -1){
//                //     System.out.println("MOVE "+allSites.get(moveTo).get("x")+ " "+allSites.get(moveTo).get("y"));
//                //     allSites.get(moveTo).put("structureType",2);
//                // }
//                // else   System.out.println("MOVE "+allSites.get(moveTo).get("x")+ " "+allSites.get(moveTo).get("y"));
//            }
//            else if(allSites.get(touchedSite).get("barrack") == -1){
//                System.out.println("BUILD "+touchedSite+ " BARRACKS-ARCHER");
//                allSites.get(touchedSite).put("barrack",1);
//            }
//            else if(allSites.get(touchedSite).get("barrack") == 1 && archers >= 4){
//                System.out.println("BUILD "+touchedSite+ " BARRACKS-KNIGHT");
//                allSites.get(touchedSite).put("barrack",0);
//                System.out.println("TRAIN");
//                continue;
//            }
//            else if(allSites.get(touchedSite).get("barrack") == 0 && archers < 4){
//                System.out.println("BUILD "+touchedSite+ " BARRACKS-ARCHER");
//                allSites.get(touchedSite).put("barrack",1);
//                System.out.println("TRAIN");
//                continue;                    }
//            else{
//                System.err.println(allSites.get(touchedSite).get("barrack") );
//                System.out.println("WAIT");
//            }
//
//            if(touchedSite != -1 && allSites.get(touchedSite).get("barrack") != -1)
//                System.out.println("TRAIN "+touchedSite);
//            else System.out.println("TRAIN");
//
//
//            // First line: A valid queen action
//            // Second line: A set of training instructions
//        }
//    }
//
}



