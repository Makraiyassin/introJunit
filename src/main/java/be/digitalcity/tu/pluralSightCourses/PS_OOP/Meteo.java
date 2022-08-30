package be.digitalcity.tu.pluralSightCourses.PS_OOP;

//@FunctionalInterface // Pas obligatoire, fonctionne sans ...
public interface Meteo {
    void temperature(int x);

    int temp = 15;
//    static void anonce (int x)
    default void anonce (int x)
    {
        if(x>temp) System.out.println("la temperature est de " + x +" degres, Il fait chaud! :)");
            else System.out.println("la temperature est de " + x +" degres, Il fait froid! :(");
    };
}
