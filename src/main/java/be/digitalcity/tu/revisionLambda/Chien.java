package be.digitalcity.tu.revisionLambda;

import java.util.Objects;

public class Chien {
    private String name;
    private int age;
    private Race race;

    public Chien(String name, int age, Race race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public Chien(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chien chien = (Chien) o;
        return age == chien.age && Objects.equals(name, chien.name) && race == chien.race;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, race);
    }

    @Override
    public String toString() {
        return "\nChien{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", race=" + race +
                '}';
    }
}
