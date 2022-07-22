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

    public String getType() throws TriangleExeption {
        if( a <= 0 || b <= 0 || c <= 0 )
            throw new TriangleExeption("Ceci n'est pas un triangle (les 3 cotes doivent etre superieur a 0)");
        if( a >= b + c || b >= a + c  || c >= a + b )
            throw new TriangleExeption("Ceci n'est pas un triangle (le plus grand cotes ne doit pas etre plus grand ou egale a la somme des deux autre cotes)");
        if (a == b && a == c) return "equilateral";
        if (a == b || a == c || b == c ) return "isocele";
        return "scalene";
    }

}
