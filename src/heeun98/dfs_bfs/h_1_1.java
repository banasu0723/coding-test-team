package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_1_1 {

    static int n;
    static int[] money;
    static int total;
    static int answer = Integer.MAX_VALUE;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        money = new int[n];
        memo = new int[501];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        total = Integer.parseInt(br.readLine());

        dfs(0, 0);
        System.out.println(memo[total]);

    }

    static void dfs(int v, int sum) {
        if (memo[sum] > 0 && memo[sum] < v) {
            return;
        }
        if (sum > total) return;
        memo[sum] = v;
        if (v == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(v + 1, sum + money[i]);
        }
    }
}
