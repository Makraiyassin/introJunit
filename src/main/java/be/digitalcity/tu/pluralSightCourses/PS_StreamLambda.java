package be.digitalcity.tu.pluralSightCourses;

import be.digitalcity.tu.pluralSightCourses.PS_OOP.Category;
import be.digitalcity.tu.pluralSightCourses.PS_OOP.Data;
import be.digitalcity.tu.pluralSightCourses.PS_OOP.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PS_StreamLambda {
    public static void main(String[] args) {

        System.out.println("============= lambda & Anonymous class=============");
        Runnable sayHello = () -> System.out.println("Hello World");

        Runnable sayHello2 = new Runnable() {
            private String message = "Hello World";
            @Override
            public void run() {
                System.out.println(this.message);
            }
        };


        sayHello.run();
        sayHello2.run();

        System.out.println("------------------------------------------------");
        ArrayList<String> products = new ArrayList<>(Arrays.asList("chaussure","pull","pull","pantalon"));
        System.out.println("====== STREAM =========");
        // Get a stream from a collection
        Stream<String> stream1 = products.stream();
        // Get a stream from an array
        String[] array = new String[]{"one", "two", "three"};
        Stream<String> stream2 = Arrays.stream(array);
        // Create a Stream from elements directly
        Stream<String> stream3 = Stream.of("one", "two", "three");
        // Create a Stream with zero or one elements with ofNullable()
        Stream<String> stream4 = Stream.ofNullable("four");
        // Create an empty Stream with Stream.empty()
        Stream<?> stream5 = Stream.empty();

        System.out.println();
        System.out.println("====== filter =========");
        System.out.println("(Predicate : T => Boolean)");
        products.stream()
                .filter(product -> product.length() >= 6 )
                .forEach(System.out::println);

        System.out.println();
        System.out.println("====== map =========");
        System.out.println("(Function : T => R)");
        products.stream()
                .map(product -> product.length()+100)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("====== flatmap =========");
        System.out.println("(Function : T => R)");
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                .flatMap(product -> spaces.splitAsStream(product.toUpperCase()))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("====== Search in streams =========");
        System.out.println("====== findFirst / findAny=========");
        Optional<String> result = products.stream()
                .filter(item -> item.contains("a"))
//                .findFirst();
                .findAny();

        System.out.println(result);

        System.out.println("====== anyMatch/allMatch/noneMatch=========");
        boolean result2 = products.stream()
//                .anyMatch(item -> item.contains("a")); //true
//                .allMatch(item -> item.contains("a")); // false
                .noneMatch(item -> item.contains("x")); // true
        System.out.println(result2);

        System.out.println("====== collect/ toList=========");
        List<String> result3 = products.stream()
                .filter(item -> item.contains("u"))
                .toList();
        System.out.println(result3);
        System.out.println("====== distinct ========");
        List<String> result4 = products.stream()
                .filter(item -> item.contains("u"))
                .distinct()
                .toList();
        System.out.println(result4);

        System.out.println();
        System.out.println("====== Generate ========");
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        uuids.limit(10).forEach(System.out::println);

        System.out.println("====== Iterate ========");
        Stream<BigInteger> powersOfTwo =Stream.iterate(
                BigInteger.ONE,
                n -> n.multiply(BigInteger.TWO)
        );
        powersOfTwo.limit(20).skip(1).forEach(System.out::println);

        System.out.println();
        Stream<Character> alphabet = Stream.iterate('A', letter ->
                letter <= 'Z', letter -> (char) (letter + 1));
        alphabet.forEach(System.out::println);

        System.out.println();
        System.out.println("====== Builder ========");
        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two")
                .add("three");
        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);

        List<Product> productList= Data.getProducts();
        System.out.println();
        System.out.println("====== reduce details =========");
        System.out.println("(binaryOperator : T, T => T)");
        Optional<BigDecimal> opt = productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add); //.reduce((result5, element) -> result5.add(element));

        System.out.println(opt);
        System.out.println();

        BigDecimal total = productList.stream()
                .reduce(
                        BigDecimal.ZERO,
                        (result6, product) -> result6.add(product.getPrice()),
                        BigDecimal::add
                );
        System.out.printf("The total value of all products is: $ %.2f%n", total);

        System.out.println();
        System.out.println("====== collect details=========");

        List<String>total2 = productList.stream()
                .collect(
                    ArrayList::new, //FOURNISSEUR
                    (list, product)->list.add(product.getName()), //ACCUMULATEUR
                    ArrayList::addAll //COMBINEUR
                );
        System.out.print(total2);

        System.out.println();
        System.out.println("====== collectectors.toMap=========");

        Map<Category, BigDecimal> totalPerCategory = productList.stream()
                .collect(
                        Collectors.toMap(
                                Product::getCategory, // Key mapper function
                                Product::getPrice, // Value mapper function
                                BigDecimal::add // Merge function
                        )
                );
        System.out.println(totalPerCategory);

        System.out.println();
        System.out.println("====== groupingBy =========");

        Map<Category, List<Product>> productsByCategory =productList.stream()
                .collect(
                        Collectors.groupingBy(Product::getCategory)
                );
        System.out.println(productsByCategory);

        System.out.println("        ---        ");
        Map<Category, List<String>> productNamesByCategory = productList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Product::getCategory,
                                        Collectors.mapping(
                                                Product::getName,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println(productNamesByCategory);
    }
}
