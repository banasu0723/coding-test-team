package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;

public class h_251022 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] gr = new int[n][m];
        Queue<int[]> number1 = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                gr[i][j] = s.charAt(j) - '0';

                if (gr[i][j] == 1 || (i == 0 && j == 0)) {
                    number1.add(new int[]{i, j});
                }
            }
        }


        int result = Integer.MAX_VALUE;
        while (!number1.isEmpty()) {

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            boolean[][] visit = new boolean[n][n];
            visit[0][0] = true;

            int[] pos = number1.poll();
            gr[pos[0]][pos[1]] = 0;

            int[][] distance = new int[n][m];

            while (!queue.isEmpty()) {

                int[] poll = queue.poll();
                int cr = poll[0];
                int cc = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dy[i];
                    int nc = cc + dx[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    if (visit[nr][nc]) continue;

                    if (gr[nr][nc] == 1) continue;

                    queue.add(new int[]{nr, nc});
                    visit[nr][nc] = true;
                    distance[nr][nc] = distance[cr][cc] + 1;
                }

            }

            gr[pos[0]][pos[1]] = 1;

            if (distance[n - 1][m - 1] != 0) {
                result = Math.min(result, distance[n - 1][m - 1] + 1);
            }

        }


        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
    }
}
