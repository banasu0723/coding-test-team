package heeun98.session3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class h_3_2 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr2);


        int idx1 = 0;
        int idx2 = 0;

        List<Integer> answer = new ArrayList<>();
        while (idx1 < n && idx2 < m) {

            if (arr1[idx1] == arr2[idx2]) {
                answer.add(arr1[idx1]);
                idx1++;
                idx2++;
                continue;
            }

            if (arr1[idx1] < arr2[idx2]) {
                idx1++;
                continue;
            }

            if (arr1[idx1] > arr2[idx2]) {
                idx2++;
            }

        }


        answer.stream()
                .forEach(s -> System.out.print(s + " "));
    }
}
