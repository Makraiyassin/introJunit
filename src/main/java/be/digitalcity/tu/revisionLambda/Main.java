package be.digitalcity.tu.revisionLambda;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("========= equals ==========");
        Chien a = new Chien("Snoopy");
        Chien b = new Chien("Snoopy");
        System.out.println(a.equals(b));

        List<Chien> chienList = Arrays.asList(
                new Chien("Droopy",3, Race.BULDOG),
                new Chien("Paf",4, Race.PITBULL),
                new Chien("eric",2, Race.CHIWAWA),
                new Chien("Pif",3, Race.DALMACIEN),
                new Chien("Pif",3, Race.DALMACIEN),
                new Chien("Pif",4, Race.DALMACIEN)
        );

        System.out.println(chienList);
        System.out.println("meme nom, age, race => "+chienList.get(3).equals(chienList.get(4)));
        System.out.println("meme nom, race mais age different=> "+chienList.get(5).equals(chienList.get(4)));

        System.out.println(rechercheParNom("eric", chienList));
        System.out.println(rechercheViaCritere(chienList,chien->chien.getName().contains("oop") && chien.getRace().equals(Race.BULDOG)));
    }

    public static Chien rechercheParNom(String name, List<Chien> chienList){
        for (Chien c: chienList ) {
            if(c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public static Chien rechercheViaCritere(List<Chien> chienList, Predicate<Chien> predicate){
        for (Chien c : chienList ) {
            if(predicate.test(c)) return  c;
        }
        return null;
    }

}
