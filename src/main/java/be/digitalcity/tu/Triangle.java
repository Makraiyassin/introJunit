package be.digitalcity.tu;

public class Triangle {
    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int coteB, int coteC) {
        this.a = a;
        this.b = coteB;
        this.c = coteC;

    }

    public String getType() {
        if(checkValidity(a,b,c)) {
            if (a == b && a == c && b == c) return "equilateral";
            if (a == b && a+b > c) return "isocele";
            if (a == c && a+c > b) return "isocele";
            if (b == c && b+c > a) return "isocele";
            if (a != b && a != c && b != c)
                if ( a + b >= c || a + c >= b || b + c >=  a ) return "scalene";
        }
        return "Ceci n'est pas un triangle";
    }

    public boolean checkValidity(int a, int b, int c){
        return a > 0 && b > 0 && c > 0;
    }
}
