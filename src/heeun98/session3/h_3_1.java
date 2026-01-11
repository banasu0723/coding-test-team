package heeun98.session3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_3_1 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] arr1 = new int[n];


        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }


        int m = Integer.parseInt(br.readLine());

        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }


        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        int[] arr3 = new int[n + m];

        while (idx1 < n && idx2 < m) {

            if (arr1[idx1] <= arr2[idx2]) {
                arr3[idx3] = arr1[idx1];
                idx3++;
                idx1++;
                continue;
            }

            if (arr1[idx1] > arr2[idx2]) {
                arr3[idx3] = arr2[idx2];
                idx3++;
                idx2++;
            }

        }
        while (idx1 < n) {
            arr3[idx3] = arr1[idx1++];
            idx3++;
        }

        while (idx2 < m) {
            arr3[idx3] = arr2[idx2++];
            idx3++;
        }

        Arrays.stream(arr3)
                .forEach(e -> System.out.print(e + " "));


    }
}
