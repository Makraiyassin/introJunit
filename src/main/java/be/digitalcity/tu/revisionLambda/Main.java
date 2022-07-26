package be.digitalcity.tu.revisionLambda;

public class Main {
    public static void main(String[] args) {

        System.out.println("========= equals ==========");
        Chien a = new Chien("Snoopy");
        Chien b = new Chien("Snoopy");
        System.out.println(a.equals(b));


    }
}
