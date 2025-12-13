package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_251212 {

    public static int[] numbers;
    public static int n;
    public static int m;
    public static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        String input = br.readLine();
        st = new StringTokenizer(input);

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);
        System.out.println(result);
    }


    static void dfs(int idx, int count, int sum) {
        if (sum > m) return;

        if (count == 3 && sum <= m) {
            result = Math.max(sum, result);
            return;
        }
        for (int i = idx; i < n; i++) {
            dfs(i + 1, count + 1, sum + numbers[i]);
        }


    }
}
