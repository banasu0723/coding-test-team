package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class h_250915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        list.stream()
                .sorted()
                .forEach(num -> sb.append(num + "\n"));
        System.out.println(sb);

    }
}
