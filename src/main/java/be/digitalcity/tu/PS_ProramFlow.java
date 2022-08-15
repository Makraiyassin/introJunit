package be.digitalcity.tu;

public class PS_ProramFlow {

    public static void main(String[] args) {

        System.out.println("========= subtilité au sujet des if/else ==========");
        int students = 0;
        int rooms = 4;

        if(students > 0)
            if(rooms > 0)
                System.out.println("Students per room: " + students / rooms);
        else //l'indentation ne compte pas -> ce else est pour le deuxieme if
            System.out.println("NO students");


        if(students > 0){
            if(rooms > 0)
                System.out.println("Students per room: " + students / rooms);
        }
            else //-> ce else est pour le premier if
                System.out.println("NO students");


        System.out.println("========= subtilité au sujet des switch ==========");

        char sign = '-';
        //peut s'ecrire de deux maniere:
        switch(sign) {
            case '+':
                System.out.println("Positive");
                break;
            case '-':
                System.out.println("Negative");
                break;
            default:
                System.out.println("Sign not recognized");
        }

        switch (sign) {
            case '+' -> System.out.println("Positive");
            case '-' -> System.out.println("Negative");
            default -> System.out.println("Sign not recognized");
        }


        String valueName = "one";
        int total = 10;
        //si on met pas de "break" à la fin de chaque block du switch, le switch va continuer a executer les autre instruction qui suivent le cas correct
        switch(valueName) {
            case "zero":
                total ++;
            case "one":
                total ++;
            case "two":
                total ++;
        }
        System.out.println(total);

        // le switch n'accepte pas de boolean
//        switch (true){
//            case 1<0:
//                System.out.println("not ok");
//            case 1>0:
//                System.out.println("ok");
//            default:
//                System.out.println("end");
//        }

        int sum = 0;
        char operation = '+';
        switch(operation) {
            case '+':
                sum++; //pas de break donc il continue jusqu'a un break
            default:
                System.out.println("Current sum: " + sum);
            case '-':
                System.out.println("Subtraction no allowed");
                break;
        }
        System.out.println("========= subtilité au sujet de ..... ==========");


    }

}
