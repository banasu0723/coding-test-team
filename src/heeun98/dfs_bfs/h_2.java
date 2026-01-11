package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_2 {


    static int c;
    static int n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(br.readLine());
            arr[i] = weight;
        }
        dfs(0, 0);

        System.out.println(answer);

    }

    static void dfs(int v, int sum) {

        if (sum > c) return;
        if (v == n) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(v + 1, sum + arr[v]);

        dfs(v + 1, sum);

    }
}
