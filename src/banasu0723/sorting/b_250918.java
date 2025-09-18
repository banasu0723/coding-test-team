package banasu0723.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class b_250918 {
    // 1181 단어정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> words = new ArrayList<>();
        for(int i = 0; i < N; i++){
            words.add(br.readLine());
        }

        List<String> sorted = words.stream()
                .distinct()
                .sorted(
                        Comparator.comparingInt(String::length) //길이
                                .thenComparing(Comparator.naturalOrder()) // 사전순
                )
                .collect(Collectors.toList());

        for(String word : sorted){
            sb.append(word).append("\n");
        }

        System.out.println(sb);


    }
}