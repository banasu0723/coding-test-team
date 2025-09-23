package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_250922 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < num ; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        list.stream()
                .sorted((o1, o2) -> {
                    if (o1[1] != o2[1]) return o1[1] - o2[1];

                    return o1[0] - o2[0];
                })
                .forEach(e -> System.out.println(e[0] + " " + e[1]));

    }
}
