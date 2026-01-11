package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class h_8 {


    static int n;
    static int f;
    static int[] result;
    static boolean[] visit;
    static int[] composition;
    static int[][] memo;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        result = new int[n + 1];
        visit = new boolean[n + 1];
        composition = new int[n + 1];
        memo = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            composition[i] = com(n - 1, i - 1);
        }


        dfs(1, 0);
    }


    static int com(int r, int v) {
        if (memo[r][v] > 0) return memo[r][v];
        if (v == 0) return 1;
        if (r == v) return 1;
        return memo[r][v] = com(r - 1, v - 1) + com(r - 1, v);
    }

    static void dfs(int v, int sum) {

        if (flag) return;
        if (sum > f) return;

        if (v == n + 1 && sum == f) {
            for (int i = 1; i <= n; i++) {
                System.out.print(result[i] + " ");
            }
            flag = true;
            return;
        }
        for (int i = 1; i <= n; i++) {

            if (visit[i]) continue;
            visit[i] = true;
            result[v] = i;
            dfs(v + 1, sum + (composition[v] * i));
            visit[i] = false;
        }
    }


}
