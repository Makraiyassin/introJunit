package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.IOException;
import java.io.StringWriter;

public class Chap4_PlayWithStringWriter {

    public static void main(String[] args) {

        try (StringWriter writer = new StringWriter();) {

            writer.write("Hello woooorld!!!");

            writer.flush();

            StringBuffer buffer = writer.getBuffer();
            String string = writer.toString();

            System.out.println(string);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
