package be.digitalcity.tu;

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle(20,4,3);
        try {
            System.out.println(t.getType());
        } catch (TriangleExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
