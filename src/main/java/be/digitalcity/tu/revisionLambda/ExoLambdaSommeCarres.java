package be.digitalcity.tu.revisionLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExoLambdaSommeCarres {
    public static void main(String[] args) {
        System.out.println(
                listIntGenerator(16).filter(x -> x % 2 != 0)
                        .map(x -> x * x)
                        .peek(System.out::println)
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        System.out.println("==================================="+ ((int)Math.pow(2,3)));

        System.out.println(
                Stream.iterate(0d, n -> n + 1)
                        .limit(16)
                        .filter(x -> x % 2 != 0)
                        .map(x -> x * x)
                        .peek(System.out::println)
                        .reduce(Double::sum)// .reduce((x,y)->Double.sum(x,y))
//                        .get()
        );

    }

    public static Stream<Integer> listIntGenerator(int x){
        List<Integer>  listInt = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            listInt.add(i);
        }
        return listInt.stream();
    }
}
