package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251207 {

    static int minDiff = Integer.MAX_VALUE;
    static int n;
    static int teamSize;
    static boolean[] visit;
    static int[][] status;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        status = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 1; j <= n; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        teamSize = n / 2;

        bfs(1,0);


        System.out.println(minDiff);

    }

    static void bfs(int idx, int count) {

        if (count == teamSize) {
            calculate();
            return;
        }
        for (int i = idx; i <= n; i++) {

            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            bfs(i + 1, count + 1);
            visit[i] = false;
        }
    }

    static void calculate() {

        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                if (visit[i] && visit[j]) {
                    sumA += status[i][j] + status[j][i];
                    continue;
                }

                if (!visit[i] && !visit[j]) {
                    sumB += status[i][j] + status[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(sumA - sumB));

    }
}
