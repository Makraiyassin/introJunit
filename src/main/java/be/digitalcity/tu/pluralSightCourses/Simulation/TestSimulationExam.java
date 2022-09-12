package be.digitalcity.tu.pluralSightCourses.Simulation;

import java.util.concurrent.Callable;
import java.util.function.*;

public class TestSimulationExam {
    public static void main(String[] args) {

        Coco coco = new Coco(1);

        SuperString string = new SubString();
        System.out.println(string.toString("test"));

//        new StandardMethods().printPerimeter(5,5); //Erreur complilation: constructeur de StandardMethods est privé


        for (int j = 0; j < 10; j++) {
//            new Thread(() -> System.out.println(j)).start(); //Exception: variable dans lambda doit etre final ou ne doit pas être modifier
        }

    }
    public static class Fruit{
        public Fruit(){
            System.out.println("hello");
        }
    }

    public static class Coco extends Fruit{
        public Coco(int x){
            System.out.println(x);
        }
//        abstract void hello();// Exception: pour mettre une methode abstraite la class doit etre abstraite
    }

    public interface StringInterface {
        public String toString();
    }

    public static class SuperString implements StringInterface {
        public String toString() {
            return "Super String 1";
        }
        public Object toString(String str) {
            return "Super String 2";
        }
    }

    static class SubString extends SuperString {
        public String toString() {
            return "Sub String 1";
        }
        public String toString(String str) {
            return "Sub String 2";
        }
    }

}

