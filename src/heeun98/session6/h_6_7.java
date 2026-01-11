package heeun98.session6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_6_7 {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];
        String input = br.readLine();

        st = new StringTokenizer(input);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int lt = arr[1] - arr[0];
        int rt = arr[n - 1] - arr[0];
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int ep = arr[0];
            int count = 1;
            for (int i = 1; i < n; i++) {

                if (arr[i] - ep >= mid) {
                    ep = arr[i];
                    count++;
                }
            }

            if (count >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);



    }
}
