package be.digitalcity.tu;

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle(6,6,6);
        try {
            System.out.println(t.getType());
        } catch (TriangleExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
