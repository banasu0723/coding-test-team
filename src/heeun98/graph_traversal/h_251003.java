package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class h_251003 {

    static boolean[][] visit;
    static boolean[][] visit2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] gr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = input.charAt(j);
                gr[i][j] = c;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(gr, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (gr[i][j] == 'G') {
                    gr[i][j] = 'R';
                }
            }
        }

        visit = new boolean[n][n];
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(gr, i, j);
                    count2++;
                }
            }
        }

        System.out.println(count2);







    }

    public static void bfs(int[][] gr, int i, int j) {

        int color = gr[i][j];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visit[i][j] = true;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int k = 0; k < 4; k++) {
                int nr = cr + dy[k];
                int nc = cc + dx[k];


                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (visit[nr][nc]) {
                    continue;
                }

                if (gr[nr][nc] != color) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;
            }

        }
    }
}
