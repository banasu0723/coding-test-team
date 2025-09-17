package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class h_250917 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        list.stream()
                .distinct()
                .sorted((o1, o2) -> {
                   if (o1.length() != o2.length()) return o1.length() - o2.length();

                   return o1.compareTo(o2);
                })
                .forEach(str -> sb.append(str + "\n"));


        System.out.println(sb);

    }
}
