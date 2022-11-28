package be.digitalcity.tu.pluralSightCourses.Simulation;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class SimuOca {
    private String name;

    public static void go(Short a) {System.out.println("short ");}
    public static void go(int a) {System.out.println("int ");}
    public static void go(Long a) {System.out.println("long ");}

    public static void main(String[] args) {
        short a = 6;
        long b = 7;
        go(a);
        go(b);

        System.out.println(
                TemporalAdjusters.next(DayOfWeek.SUNDAY)
                        .adjustInto(LocalDate.now())
        );


        System.out.println("abc : "+parseFloat("0.0"));
        System.out.println(Double.valueOf(b));

        SimuOca simu = new SimuOca();
        System.out.println(simu.name);

        StringBuilder sb = new StringBuilder("abc");
        sb.append("-def");
        System.out.println(sb);

    }

    public static float parseFloat( String s ){
        byte by = 'a';
        System.out.println("byte: "+by);
        float f = 0.0f;
        try{
            f = Float.valueOf( s ).floatValue();
            System.out.println(f);
            return f ;
        }
        catch(NumberFormatException nfe){
            f = Float.NaN ;
            return f;
        }
        finally{
            f = 10.0f;
            return f;
        }
    }
}

class Alpha{
    public void foo(String... args){
        System.out.println("Alpha : foo");
    }
    public void bar(String a){
        System.out.println("Alpha : bar");
    }
}

class Beta extends Alpha{
    public void foo(String a){
        System.out.println("Beta : foo");
    }
    public void bar(String a){
        System.out.println("Beta : bar");
    }
    public static void main(String[] args) {
        Alpha a = new Beta();
        Beta b = (Beta) a;
        Alpha c = (Alpha) (new Beta());
        a.foo("a");
        b.foo("a");
        a.bar("a");
        b.bar("a");
    }
}

interface A {
    public void doSomething(String a);
//    abstract void a();
    int a = 0001;
}
class AImpl implements A{
    String name = "A";
    String getName(){return name;}
    String greeting(){return "class A";}
    public void doSomething(String a){};
}

class BImpl extends AImpl{
    String name = "B";
    String greeting(){return "class B";}

}
class B{
    public A doit(){return new AImpl();};
    public Object  execute(){return "";};
    public String  execute2(){return "";};
    String testOverrid(int a){return "";};
}
class C extends B{
    public AImpl doit(){return new AImpl();}
    public String execute(){return "";}
//    public Object execute2(){return "";} // compile fail object not "is string" but "has string"
    private String testOverrid(String a){return "";};
}

class Test{
    public static void main(String[] args) {
        AImpl a = new AImpl();
        BImpl b = new BImpl();
        System.out.println(a.greeting()+" name: "+a.getName());
        System.out.println(b.greeting()+" name: "+b.getName());
    }
}

class Hello{
    String title;
    int value;
    public Hello(){
        title += " World";
    }

    public Hello(int value){
        this.value = value;
        title = "Hello";
//        Hello(); //comp fails
    }
}


