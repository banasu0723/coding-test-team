package heeun98.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;

public class h_250921 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end});

        }

        list.sort((o1 , o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];

            return o1[0] - o2[0];
        });

        int pre = 0;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] e = list.get(i);
            int start = e[0];
            int end = e[1];

            if (start < pre) {
                continue;
            }
            count++;
            pre = end;
        }
        System.out.println(count);
    }
}
