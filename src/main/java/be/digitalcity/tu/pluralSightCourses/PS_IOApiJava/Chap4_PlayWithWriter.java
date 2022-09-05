package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Chap4_PlayWithWriter {

    public static void main(String[] args) {

        try (Writer writer = new FileWriter("files/words.txt")) {

            writer.write("Hello world!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
