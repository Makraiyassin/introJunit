package be.digitalcity.tu.pluralSightCourses.Simulation;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable <Student> {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(3, "George" ));
        students.add(new Student(4, "Robin" ));
        students.add(new Student(1, "Aima" ));
        students.add(new Student(3, "Robin" ));
        Collections.sort(students);
        System.out.print(students);
    }

    private int id; private String name;

    public Student(int id, String name) {
        this.id = id; this.name = name;
    }

    public int compareTo(Student s) {
        return name.equals(s.name) ?
                Integer.valueOf(id).compareTo(s.id) :
                name.compareTo(s.name);
    }

    public String toString() { return id + ": " + name; }

}
