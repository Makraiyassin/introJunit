package be.digitalcity.tu.pluralSightCourses.PS_Collections;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PS_Collections {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,11,5,9,8,1));
        System.out.println(set.toString());
        System.out.println(set.toString());
        System.out.println(set.toString());

        Set<String> set2 = new HashSet<>();
        set2.add("one");
        set2.add("two");
        set2.add("three");

        List<String> listSet2 = new ArrayList<>(set2);
        System.out.println(listSet2.get(1));

        Integer[] fibonacci = {0,1,1,2,3,5,8,13,21,34,55};

        List<Integer> intList = Arrays.asList(fibonacci);
        Collections.shuffle(intList);
        intList.toArray(fibonacci);
        System.out.println(Arrays.toString(fibonacci));
//        Arrays.sort(fibonacci);

        System.out.println(Arrays.binarySearch(fibonacci,8));

        Set<Integer> treeSetFibonacci = new TreeSet<>(Arrays.asList(fibonacci));
        Set<Integer> hashSetFibonacci = new HashSet<>(Arrays.asList(fibonacci));
        System.out.println(treeSetFibonacci);
        System.out.println(hashSetFibonacci);

        System.out.println("\n================ Comparison array ==========");
        int[] array1 = {1,0,3,4,9,6,7};
        int[] array2 = {1,2,3,4,5,6,7};

        System.out.println(array1.equals(array2));
        System.out.println(Arrays.equals(array1,array2));
        System.out.println(Arrays.compare(array1,array2));
        System.out.println(Arrays.mismatch(array1,array2));

        System.out.println("\n================ args ==========");
        System.out.println(Arrays.toString(args));

        System.out.println("\n========= array multi =========");

        String[][][] multiArray = new String[3][5][4];
        for (String [][] multiAr : multiArray) {
            System.out.println(Arrays.toString(multiAr));

            for (String [] ar :multiAr) {
//                System.out.println(Arrays.toString(ar));
            }
        }

        String[][] westCoastCitiesGrouped = new String[][]{
                {"LA", "San Francisco", "San Diego"},
                {"Seattle", "Tacoma"},
                {"Portland"}
        };

        for (String [] ar : westCoastCitiesGrouped) {
            for (String word: ar) {
                System.out.println(word);
            }
        }

        System.out.println("\n======== chapter \"List/ArrayList\" ========");
//        List<String> listString = new ArrayList<>(Arrays.asList("hello","world","!"));
        List<String> listString = new ArrayList<>();
        listString.add("world");
        listString.add(1,"!");
        listString.add(0,"hello");
        listString.add(listString.size(),"?");
        System.out.println(listString.toString());


        Object[] arrayString = listString.toArray();
        System.out.println(Arrays.toString(arrayString));
        List listString2 = Arrays.asList(arrayString);
        System.out.println(listString2.getClass().getName());
        System.out.println(new ArrayList<>(Arrays.asList(1,2,3)).add(4)); //true
//        System.out.println(Arrays.asList(1,2,3).add(4)); //Exception because it isn't a true ArrayList => java.util.Arrays$ArrayList

        System.out.println("\n===== LinkedList =====");
        LinkedList<String> orders = new LinkedList<>();
        orders.add("order 1");
        orders.add("order 2");
        orders.add("order 3");
        System.out.println(orders);
        orders.addFirst("order 4");
        orders.addLast("order 5");
        System.out.println(orders);
        orders.removeFirst();
        orders.removeLast();
        System.out.println(orders);

        System.out.println("\n===== Sorting list =====");
        List<Integer> integerList= new ArrayList<>(Arrays.asList(8,7,5,2,15,54,6,4464,4));
        Collections.sort(integerList);
        System.out.println(integerList);

        List<String> stringList= new ArrayList<>(Arrays.asList("lundi","mardi","mercredi","jeudi","vendredi","Samedi","Dimanche"));
        Collections.sort(stringList);
        System.out.println(stringList);

        stringList = stringList.stream().map(String::toLowerCase).collect(Collectors.toList());
        Collections.sort(stringList);
        System.out.println(stringList);

        System.out.println("\n===== comparateur en implematant comparable<T> dans la class mountain(ici en croissant)=====");

        List<Mountain> mountains = new ArrayList<>(List.of(
                new Mountain("Everest", 8848),
                new Mountain("K2", 8611),
                new Mountain("Matterhorn", 4478)
        ));

        System.out.println(mountains.stream().map(Mountain::getName).toList());
        Collections.sort(mountains);
        System.out.println(mountains.stream().map(Mountain::getName).toList());

        System.out.println("\n===== autre methode de comparateur (ici en decroissant)======");
        Comparator<Mountain> mountainComparator = new Comparator<Mountain>() {
            @Override
            public int compare(Mountain m1, Mountain m2) {
                return m2.getHeight() - m1.getHeight();
            }
        };

        Collections.sort(mountains,mountainComparator);
        System.out.println(mountains.stream().map(Mountain::getName).toList());

        System.out.println("\n===== meme methode de comparateur mais avec lambda(ici en croissant)======");
        Comparator<Mountain> mountainComparator2 = (m1,m2)->m1.getHeight()-m2.getHeight();
        Collections.sort(mountains,mountainComparator2);
        System.out.println(mountains.stream().map(Mountain::getName).toList());

        System.out.println("\n===== Set ======");

        Set<Integer> setHash = new HashSet<>();
        Set<Integer> setTree = new TreeSet<>();

        setHash.add(10);
        setHash.add(7);
        setHash.add(6119);
        setHash.add(9);

        setTree.add(10);
        setTree.add(7);
        setTree.add(6119);
        setTree.add(9);

        System.out.println(setHash);
        System.out.println(setTree);


        System.out.println(setHash.isEmpty());
        System.out.println(setHash.size());
        System.out.println(setHash.add(5));
        System.out.println(setHash.add(5));
        System.out.println(setHash.remove(5));
        System.out.println(setHash.remove(5));

        System.out.println("\n===== HashMap======");

        Map countries = new HashMap();
        countries.put(1,"USA");
        countries.put(2,"MEX");
        countries.put("30","CAN");
        System.out.println(countries.get("30"));
        System.out.println(countries.get(2));
        System.out.println(countries);

        HashMap<Integer, String> countries2 = new HashMap<>();
        countries2.put(1,"USA");
        countries2.put(2,"MEX");
        countries2.put(3,"CAN");
        countries2.put(3,"ABC");
        countries2.put(-3,null);
        countries2.put(null,null);
        System.out.println(countries2);

        System.out.println("\n===== TreeMap======");

        Map<String,String> animals = new TreeMap<>();
        animals.put("dog","pitbull");
        animals.put("cat","tom");
        animals.put("mouse","jerry");
        System.out.println(animals.keySet());
        System.out.println(animals.values());

    }
    public static class Mountain implements Comparable<Mountain> {
        private String name;
        private int height;

        public Mountain(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Mountain o) {
            return  this.height - o.height;
        }
    }

}
