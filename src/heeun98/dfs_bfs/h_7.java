package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_7 {


    static int[][] memo;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        memo = new int[n + 1][n + 1];

        int dfs = dfs(n, r);
        System.out.println(dfs);

    }

    static int dfs(int n, int r) {
        if (memo[n][r] != 0) return memo[n][r];


        if (r == 1) return memo[n][r] = n;
        if (r == n) return memo[n][r] = 1;

        return memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);

    }


}
