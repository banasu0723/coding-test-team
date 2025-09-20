package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_250918 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.add(new int[]{n1, n2});
        }

        list.sort(((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];

            return o1[1] - o2[1];
        }));

        list.stream()
                .forEach(o -> System.out.println(o[0] + " " + o[1]));
    }
}
