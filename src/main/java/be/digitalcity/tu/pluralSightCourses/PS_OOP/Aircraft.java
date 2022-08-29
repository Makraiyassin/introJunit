package be.digitalcity.tu.pluralSightCourses.PS_OOP;

public abstract class Aircraft{
    private int altitude;

    public Aircraft(int altitude) {
        this.altitude = altitude;
    }

    public abstract void land();

    public int getAltitude(){
        return this.altitude;
    }
}
