package be.digitalcity.tu.pluralSightCourses.PS_OOP;

public enum Couleur {
    ROUGE("red"),
    VERT("green"),
    BLEU("blue"),
    ORANGE("orange"),
    JAUNE("yellow"),
    INDIGO("indigo"),
    VIOLET("violet");

    private final String couleur;

    Couleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String rainbow() {
        return couleur + " and all another color in this enum is the rainbow's color ";
    }


}
