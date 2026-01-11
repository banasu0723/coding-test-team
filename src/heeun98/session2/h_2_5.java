package heeun98.session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_2_5 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                fill(arr, i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void fill(int[] arr, int num) {
        int idx = num;
        while (idx < arr.length) {
            arr[idx] = 1;
            idx = idx + num;//
        }
    }
}
