package heeun98.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class h_r_4 {

    static int[] fibo;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fibo = new int[n + 1];

        dfs(n);

        for (int i = 0; i <= n; i++) System.out.print(fibo[i] + " ");
    }

    private static int dfs(int n) {

        if (fibo[n] > 0) return fibo[n];

        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = dfs(n - 2) + dfs(n - 1);

    }
}
