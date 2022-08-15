package be.digitalcity.tu;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class PS_Exceptions {

    public static void main(String[] args) {
        System.out.println("========= systeme.exit ==========");
//        try {
//            System.exit(0); // veut dire d'arrêter l'exécution du programme
//        }
//        finally{
//            System.out.println("Ligne non exécutée");
//        }

        System.out.println("========= hierarchie exceptions ==========");

        StringBuilder sb = new StringBuilder();
        String str = null;
        try {
            sb.append("a");
            str.toUpperCase();
            sb.append("b");
        } catch (IllegalArgumentException e) {
            sb.append("c");
        } catch (Exception e) {
            sb.append("d");
        } finally {
            sb.append("e");
        }
        System.out.println(sb); //ade


        System.out.println("============= close without try with ressource ==============");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/be/digitalcity/tu/testFileReader.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {// je déclare un nouveau try/catch à l’intérieur pour gérer la
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("============= close with try with ressource ==============");

        try (
                BufferedReader br2 = new BufferedReader(new FileReader("src/main/java/be/digitalcity/tu/testFileReader.txt"));
        ) {
            String line;
            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.format("FileNotFoundException: %s%n", e);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println("============= demo try with ressource ==============");

        String Mastring = "ma string";
        try (
                FileInputStream in = new FileInputStream("src/main/java/be/digitalcity/tu/testFileReader.txt");
                FileOutputStream out = new FileOutputStream("src/main/java/be/digitalcity/tu/copyOfTestFileReader.txt")
        ) {
            out.write(in.readAllBytes());
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("============= checked vs unchecked ============");

        try {
            doThat(); //ne compile pas si je met pas dans try.catch
        } catch (IOException e) {
            e.printStackTrace();
        }

//        doThis(); //pas d'erreur de compilation mais erreur à l'execution

        System.out.println("=============  ArithmeticException ============");

        try {
            int result = 5 / 0;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        System.out.println("=============  ArrayIndexOutOfBoundsException ============");

        try{
            int[] arr = new int[1];
            System.out.println(arr[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


        System.out.println("=============  IllegalArgumentException ============");

        try {
            int age = 15;
            if (age < 21) {
                throw new IllegalArgumentException("message");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        System.out.println("=============  NullPointerException ============");

        try {
            String s1 = null;
            s1.toLowerCase();
        } catch (NullPointerException e){
            e.printStackTrace();
        }



    }

    private static void doThat() throws IOException {
        throw new IOException();
    }

    private static void doThis() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

}
