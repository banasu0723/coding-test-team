package heeun98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class h_250908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            list.add(br.readLine());
        }

        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));

        List<String> result = new ArrayList<>();

        for (String key : collect.keySet()) {
            if (collect.get(key) == 2) {
                result.add(key);
            }
        }
        System.out.println(result.size());
        result.stream()
                .sorted()
                .forEach(
                        v -> System.out.println(v)
                );
    }
}
