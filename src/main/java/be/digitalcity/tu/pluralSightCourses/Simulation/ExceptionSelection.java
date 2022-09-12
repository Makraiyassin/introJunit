package be.digitalcity.tu.pluralSightCourses.Simulation;

public class ExceptionSelection {
    private Exception ex;

    public ExceptionSelection(Exception ex) {
        this.ex = ex;

    }

    public void throwException() throws Exception  {
        System.out.println("Method started...");
        throw ex;
    }

    public static void main (String[] args) throws Exception  {
        ExceptionSelection exObj = new ExceptionSelection(new UnsupportedOperationException());
        exObj.throwException();
        System.out.println("Method ended.");
    }
}
