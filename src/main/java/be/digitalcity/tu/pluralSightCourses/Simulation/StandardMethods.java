package be.digitalcity.tu.pluralSightCourses.Simulation;

public class StandardMethods {
    private StandardMethods() { System.out.println("Constructor invoked!"); }
    public static void printPerimeter(double... sides) {
        double result = 0;
        for (double side: sides) {
            result += side;
        }
        System.out.println("Perimeter is " + result);
    }
}
