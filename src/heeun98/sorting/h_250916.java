package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class h_250916 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        List<Integer> listV1 = list.stream()
                .sorted()
                .collect(Collectors.toList());

        int minSum = 0;
        int result = 0;

        for (int i = 0; i < listV1.size(); i++) {
            minSum += listV1.get(i);
            result += minSum;
        }
        System.out.println(result);
    }
}
