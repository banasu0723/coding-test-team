package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {

    public static void main(String[] args) {


        // 기본 기능
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList()); // 수정 가능 리스트를 반환

        System.out.println("list = " + list);

        List<Integer> unmodifiableList = Stream.of(1, 2, 3)
                .collect(Collectors.toUnmodifiableList()); // 수정 불가능 리스트

        System.out.println("unmodifiableList = " + unmodifiableList);


        Set<Integer> set = Stream.of(1, 2, 2, 3, 3, 3)
                .collect(Collectors.toSet());// toSet()만 하는거 존재하지 않아
        System.out.println("set = " + set);


        /**
         *  <TreeSet>
         * 	•	숫자(Integer) → 오름차순 (1, 2, 3, 4, 5 …)
         * 	•	문자열(String) → 사전순(lexicographical order, 즉 compareTo 기준)
         * 	•	커스텀 객체 → Comparable 구현체의 compareTo() 결과 기준, 혹은 생성 시 전달한 Comparator 기준
         */

        // 타입 지정
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 2, 1)
                .collect(Collectors.toCollection(TreeSet::new)); // TreeSet 은 순서유지
        System.out.println("treeSet = " + treeSet);

    }
}
