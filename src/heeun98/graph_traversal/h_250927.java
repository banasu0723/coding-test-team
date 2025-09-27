package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_250927 {


    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] distance;
    private static boolean[][] visit;
    private static int c;
    private static int r;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] gr = new int[r][c];
        distance = new int[r][c];
        visit = new boolean[r][c];
        int total = 0;


        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    total++;
                }
                if (num == 1) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
                gr[i][j] = num;
            }
        }

        int max = 0;

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }


                if (visit[nr][nc]) {
                    continue;
                }

                if (gr[nr][nc] == -1) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                total--;
                visit[nr][nc] = true;
                distance[nr][nc] = distance[cr][cc] + 1;
                if (max < distance[nr][nc]) {
                    max = distance[nr][nc];
                }
            }

        }


        int result = total > 0 ? -1 : max;

        System.out.println(result);


    }


}
