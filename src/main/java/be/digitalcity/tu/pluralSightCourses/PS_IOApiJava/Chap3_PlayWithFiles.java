package be.digitalcity.tu.pluralSightCourses.PS_IOApiJava;

import java.io.File;
import java.io.IOException;

public class Chap3_PlayWithFiles {

    public static void main(String[] args) throws IOException {

        System.out.println("============= Infos of file ==============");

        File file0 = new File("files/sonnet2.txt");
        System.out.println("file = " + file0);
        System.out.println("file exist? = " + file0.exists());
        System.out.println("file is directory? = " + file0.isDirectory());
        System.out.println("file is file? = " + file0.isFile());

        System.out.println("============= Create new file ==============");

        File file = new File("files/sonnet2.txt");
        boolean fileCreated = file.createNewFile();
        System.out.println("fileCreated = " + fileCreated);

        System.out.println("============= Create new directory ==============");

        File dir = new File("files/data2/more-data");
        boolean dirCreated = dir.mkdir();
        System.out.println("dirCreated = " + dirCreated);
        boolean mkdirs = dir.mkdirs();
        System.out.println("mkdirs = " + mkdirs);
        boolean mkdirs2 = dir.mkdirs();
        System.out.println("mkdirs2 = " + mkdirs2);

        boolean delete = dir.delete();
        System.out.println("delete = " + delete);

        System.out.println("============= Infos of file (Path) ==============");

        File img = new File("images/.././././images/mountain.jpg");
        String name = img.getName();
        String parent = img.getParent();
        String path = img.getPath();

        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("path = " + path);

        System.out.println("============= Infos of file (Abslolute/Canonical Path) ==============");

        String absolutePath = img.getAbsolutePath();
        String canonicalPath = img.getCanonicalPath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("canonicalPath = " + canonicalPath);
        System.out.println("canonicalPath = " + file.getCanonicalPath());
        System.out.println("canonicalPath = " + file.getCanonicalFile().isFile());
        System.out.println("canonicalPath = " + dir.getCanonicalPath());
        System.out.println("canonicalPath = " + dir.getCanonicalFile().isDirectory()); //why false ???
    }
}
