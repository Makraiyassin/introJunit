package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.*;
import java.util.Arrays;

public class Chap5_ReadingCharactersFromBytes {

    public static void main(String[] args) {

        String hello = "Hello world!";

        ByteArrayOutputStream buffer = null;
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(bos);
        ) {

            writer.write(hello);
            buffer = bos;

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = buffer.toByteArray();

        for (byte b : bytes){
            System.out.printf("byte %x : %s\n", b,b);
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             InputStreamReader isr = new InputStreamReader(bis);
             BufferedReader reader = new BufferedReader(isr);) {

            String s = reader.readLine();
            System.out.println("s = " + s);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
