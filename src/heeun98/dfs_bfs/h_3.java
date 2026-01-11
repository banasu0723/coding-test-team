package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class h_3 {

    static int n;
    static int m;
    static Problem[] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Problem[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[i] = new Problem(score, time);
        }

        dfs(0, 0, 0);


        System.out.println(answer);
    }

    static void dfs(int v, int sum, int time) {

        if (time > m) return;

        if (v == n) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(v + 1, sum + arr[v].score, time + arr[v].time);

        dfs(v + 1, sum, time);


    }

    static class Problem {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
