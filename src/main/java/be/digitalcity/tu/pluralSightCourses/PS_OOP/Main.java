package be.digitalcity.tu.pluralSightCourses.PS_OOP;

public class Main {

    public static void main(String[] args) {
        System.out.println("============== Abstrat class (Overloading) =================");
        Plane plane = new Plane(10);
        plane.land();
        System.out.println("altitude: "+plane.getAltitude());
        System.out.println();
        Plane plane2 = new Plane();
        plane.land();
        System.out.println("altitude: "+plane2.getAltitude());

        System.out.println();
        System.out.println("===============Interface Functionnel =========");
        Meteo meteo = Meteo::anonce; // (x)->Meteo.anonce(x);
        meteo.temperature(10);

        System.out.println();
        System.out.println("=============== Class annonyme =========");
        Meteo meteo2 = new Meteo() {
            @Override
            public void temperature(int x) {
                System.out.println("la temperature est de "+x+" degres, Il fait chaud! :)");
            }
        };
        meteo2.temperature(20);

        Meteo meteo3 = new Meteo() {
            @Override
            public void temperature(int x) {
                double farenheit = (double) x * 9/5 + 32;
                System.out.println("temperature: "+x+" degres celcius qui est l'equivalant de "+farenheit+" degres farenheit");
            }
        };
        meteo3.temperature(20);

        System.out.println();
        System.out.println("============== lambda =========");

        Meteo meteo4 = (x) ->  System.out.println("temperature: "+x+" degres celcius qui est l'equivalant de "+((double) x * 9/5 + 32)+" degres farenheit");

        meteo4.temperature(11);

        System.out.println();
        System.out.println("=============== Enum =========");
        Couleur couleur = Couleur.BLEU;
        System.out.println(couleur.getCouleur());
        System.out.println(couleur.rainbow());

        System.out.println();
        System.out.println("=============== Nested Class =========");
        AircraftNestedClass aircraft1 = new AircraftNestedClass(100, true);
        AircraftNestedClass aircraft2 = new AircraftNestedClass(300, true);
        AircraftNestedClass aircraft3 = new AircraftNestedClass(700, true);
        System.out.println(aircraft1.getSeparationInFeet());
        System.out.println(aircraft2.getSeparationInFeet());
        System.out.println(aircraft3.getSeparationInFeet());

    }

}
