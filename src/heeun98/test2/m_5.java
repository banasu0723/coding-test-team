package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class m_5 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int idx1 = 0;
        int idx2 = 0;
        List<Integer> answer = new ArrayList<>();

        while (idx1 < arr1.length && idx2 < arr2.length) {

            if (arr1[idx1] < arr2[idx2]) {
                answer.add(arr1[idx1]);
                idx1++;
            } else {
                answer.add(arr2[idx2]);
                idx2++;
            }

        }

        while (idx1 < arr1.length) {
            answer.add(arr1[idx1]);
            idx1++;
        }


        while (idx2 < arr2.length) {
            answer.add(arr2[idx2]);
            idx2++;
        }


        int[] array = answer.stream().mapToInt(e -> e).toArray();

        for (int i : array) {
            System.out.print(i + " ");
        }


    }
}
