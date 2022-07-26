package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Chap5_PlayWithObjectInputStream {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("files/users.bin");
             ObjectInputStream ois = new ObjectInputStream(fis);) {

            Object o1 = ois.readObject();
            Object o2 = ois.readObject();

            System.out.println("jennifer = " + o1);
            System.out.println("paul = " + o2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
