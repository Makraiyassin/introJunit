package be.digitalcity.tu.revisionLambda;

public class FonctionAnonymes {
    public static void main(String[] args) {
        Chien snoopy = new Chien("Snoopy");
        Deplacement<Chien> fnDeplacement = (x) -> System.out.println(x);
        fnDeplacement.seDeplacer(snoopy);
    }
}
