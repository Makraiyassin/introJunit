package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.*;

public class Chap5_PlayWithInputStream {

    public static void main(String[] args) {

        byte [] header = {0xC, 0xA, 0xF, 0xE, 0xB, 0xA, 0xB, 0xE};

        try (OutputStream os = new FileOutputStream("files/data.bin")) {
            os.write(header);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("files/data.bin")) {
            byte[] allBytes = is.readAllBytes();
            for (byte b : allBytes) {
                System.out.printf("0x%x ", b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
