package heeun98.session4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_4_4 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();

        StringTokenizer st = new StringTokenizer(a);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        String input = br.readLine();
        st = new StringTokenizer(input);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) { // k = 4
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {

            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            result.add(map.size());

            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        result.stream().forEach(s -> System.out.print(s + " "));


    }
}
