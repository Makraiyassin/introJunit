package be.digitalcity.tu.pluralSightCourses;

import java.util.Arrays;

public class PS_Generics<T>{

    public static void main(String[] args) {

        PS_Generics<String > widget = new PS_Generics<>();
        widget.setType("hello");

//        System.out.println(firstArrayElement(new String[]{widget.getType(),widget.getType(),widget.getType(),widget.getType(),widget.getType()}));
        System.out.println(firstArrayElement(new Integer[]{1,2,3,4,5}));



    }

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static <T> String firstArrayElement(T[] t){
        if(t.length>0){
            Arrays.stream(t).forEach(System.out::println);
            return "yo";
        }
        return null;
    }
}


