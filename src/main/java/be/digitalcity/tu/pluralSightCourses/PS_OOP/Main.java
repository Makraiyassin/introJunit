package be.digitalcity.tu.pluralSightCourses.PS_OOP;

public class Main {

    public static void main(String[] args) {
        Plane plane = new Plane();
        plane.land();
        System.out.println(plane.getAltitude());

        System.out.println("===============Interface Functionnel =========");
        Meteo meteo = Meteo::anonce; // (x)->Meteo.anonce(x);
        meteo.temperature(10);


        System.out.println("=============== Enum =========");
        Couleur couleur = Couleur.BLEU;
        System.out.println(couleur.getCouleur());
        System.out.println(couleur.rainbow());

        System.out.println("=============== Nested Class =========");
        AircraftNestedClass aircraft1 = new AircraftNestedClass(100, true);
        AircraftNestedClass aircraft2 = new AircraftNestedClass(300, true);
        AircraftNestedClass aircraft3 = new AircraftNestedClass(700, true);
        System.out.println(aircraft1.getSeparationInFeet());
        System.out.println(aircraft2.getSeparationInFeet());
        System.out.println(aircraft3.getSeparationInFeet());

    }

}
