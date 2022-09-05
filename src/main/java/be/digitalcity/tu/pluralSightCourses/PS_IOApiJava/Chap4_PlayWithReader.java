package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class Chap4_PlayWithReader {

    public static void main(String[] args) {

        try (Reader reader = new FileReader("files/sonnet.txt");) {

            char[] buf = new char[16];
            int read = reader.read(buf);

            StringBuilder sb = new StringBuilder();
            while (read > 0) {
//                System.out.println("read: "+read);
//                System.out.println("buf: "+ Arrays.toString(buf));
//                System.out.println("********************\n"+sb+"\n********************");
                sb.append(buf, 0, read);
                read = reader.read(buf);
            }
            System.out.println("sb = \n" + sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
