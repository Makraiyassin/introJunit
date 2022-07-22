package be.digitalcity.tu;

public class Main {
    public static void main(String[] args) {

        Triangle t = new Triangle(6,6,6);
        Iban i = new Iban("BE76377084366795");

        try {
//            System.out.println(t.getType());
            System.out.println(i.isValide());
        } catch (IbanExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
