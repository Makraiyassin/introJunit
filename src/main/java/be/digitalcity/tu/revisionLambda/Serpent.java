package be.digitalcity.tu.revisionLambda;

import java.util.Objects;

public class Serpent {
    private String name;

    public Serpent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serpent serpent = (Serpent) o;
        return Objects.equals(name, serpent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
