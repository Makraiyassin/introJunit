package be.digitalcity.tu;

public class FortisJames {
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(str.equals(new StringBuilder(str).reverse().toString()));
    }

    static String getString() {return "";};
    static String function() {
        try {
            return getString();
        }
        catch (NumberFormatException e1) {
            return "world fin error";
        }
        catch(IllegalArgumentException e2) {
            return "list error";
        }
    }

}
class MySingleton{
    private static  MySingleton instance;
    public static MySingleton getInstance(){
        if(instance == null) instance = new MySingleton();
        return instance;
    }
    private MySingleton() {
    }
}
