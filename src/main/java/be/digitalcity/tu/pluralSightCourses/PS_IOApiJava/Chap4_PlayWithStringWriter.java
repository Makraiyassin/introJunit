package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.IOException;
import java.io.StringWriter;

public class Chap4_PlayWithStringWriter {

    public static void main(String[] args) {

        try (StringWriter writer = new StringWriter();) {

            writer.write("Hello world!");

            writer.flush();

            StringBuffer buffer = writer.getBuffer();
            String string = writer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
