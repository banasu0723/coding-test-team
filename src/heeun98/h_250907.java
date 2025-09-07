package heeun98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class h_250907 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Map<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(collect.getOrDefault(number, 0L) + " ");
        }

        System.out.println(sb);
    }
}
