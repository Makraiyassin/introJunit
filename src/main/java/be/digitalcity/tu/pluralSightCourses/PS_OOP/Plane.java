package be.digitalcity.tu.pluralSightCourses.PS_OOP;


public class Plane extends Aircraft {

    public Plane(int altitude) {
        super(altitude);
    }

    //Overloading
    public Plane() {
        super(200);
    }


    @Override
    public void land() {
        System.out.println("atterrissage de l'avion");
    }
}

