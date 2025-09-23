package stream.collectors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Collectors2Map {

    public static void main(String[] args) {

        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));

        System.out.println("map1 = " + map1);



        /*// 키 중복 예외: java.lang.IllegaStateException
        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));

        System.out.println("map2 = " + map2);*/




        // 키 중복 대안 (병합)
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (oldVal, newVal) -> oldVal + newVal // 중복될 경우 기존 값 + 새값
                ));

        System.out.println("map3 = " + map3);



        // Map의 타입 지정
        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length(),
                        (oldVal, newVal) -> oldVal + newVal, // 중복될 경우 기존 값 + 새값
                        LinkedHashMap::new
                ));

        System.out.println("map4 = " + map4.getClass());


        Map<String, Integer> map = Stream.of("Apple", "Apple", "Banana", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        key -> key,
                        key -> 1,
                        (oldVar, newVar) -> oldVar + newVar
                ));

        System.out.println("map = " + map);


        List<String> fruits = List.of("Apple", "Apple", "Banana", "Banana");

        Map<String, Long> collect = fruits.stream()
                .collect(Collectors.groupingBy(
                        key -> key,
                        Collectors.counting()
                ));
        System.out.println("collect = " + collect);


    }
}
