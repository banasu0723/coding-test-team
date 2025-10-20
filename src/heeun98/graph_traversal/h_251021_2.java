package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_251021_2 {

    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] gr = new int[n][n];

        int max = 0;


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, gr[i][j]);
            }

        }

        int[][] water;
        boolean[][] visit;
        int maxResult = 0;

        for (int h = 0; h <= max; h++) {
            int count = 0;
            water = new int[n][n];
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (gr[i][j] <= h) {
                        water[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (water[i][j] == 0 && !visit[i][j]) {
                        bfs(i,j,water,visit);
                        count++;
                    }
                }
            }

            maxResult = Math.max(maxResult, count);
        }

        System.out.println(maxResult);



    }


    static void bfs(int r, int c, int[][] water, boolean[][] visit) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (visit[nr][nc]) {
                    continue;
                }

                if (water[nr][nc] == 1) {
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visit[nr][nc] = true;
            }
        }
    }
}
