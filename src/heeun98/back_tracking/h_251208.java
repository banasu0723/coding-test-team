package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_251208 {

    static int[] numbers;
    static int s;
    static int n;
    static int min = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];


        String input = br.readLine();

        st = new StringTokenizer(input);

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(min);
    }


    static void dfs(int idx, int result) {
        if (result == s && idx != 0) {
            min++;
        }
        for (int i = idx; i < numbers.length; i++) {
            dfs(i + 1, result + numbers[i]);
        }
    }
}
