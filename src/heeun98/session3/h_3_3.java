package heeun98.session3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class h_3_3 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] arr = new int[n];

        String s = br.readLine();

        StringTokenizer st1 = new StringTokenizer(s);


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int start = 0;
        int end = m - 1;//2
        int sum = Arrays.stream(arr).limit(m).sum();
        int answer = Integer.MIN_VALUE;
        answer = Math.max(answer, sum);

        while (end < arr.length - 1) {
            end++;
            sum = sum - arr[start] + arr[end];
            start++;
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
