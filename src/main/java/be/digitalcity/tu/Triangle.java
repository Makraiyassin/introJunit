package be.digitalcity.tu;

public class Triangle {
    private int a;
    private int b;
    private int c;
    private String type;

    public Triangle(int a, int coteB, int coteC) {
        this.a = a;
        this.b = coteB;
        this.c = coteC;
        this.type = getType();

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public String getType() {
        if(checkValidity(a,b,c)) {
            if (a == b && b == c && c == a)
                return "equilateral";
            if (a == b || a == c || b == c)
                return "isocele";
            if (a != b && a != c && b != c)
                return "scalene";
        }
        return "Ceci n'est pas un triangle rectangle";
    }

    public boolean checkValidity(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return false;
        return a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b;
    }
}
