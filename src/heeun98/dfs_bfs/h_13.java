package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_13 {

    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int[] dr = {1, -1, 0, 0, 1,1 , -1, -1};
    static int[] dc = {0, 0, 1, -1, 1,-1, 1, -1};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) continue;
                if (arr[i][j] == 0) continue;
                bfs(i, j);
                count++;

            }
        }

        System.out.println(count);

    }


    static void bfs(int r, int c) {

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        visit[r][c] = true;


        while (!que.isEmpty()) {

            int size = que.size();

            for (int j = 0; j < size; j++) {

                int[] poll = que.poll();

                for (int i = 0; i < 8; i++) {
                    int nr = poll[0] + dr[i];
                    int nc = poll[1] + dc[i];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (arr[nr][nc] == 0) continue;
                    if (visit[nr][nc]) continue;

                    visit[nr][nc] = true;
                    que.offer(new int[]{nr, nc});
                }
            }
        }

    }

}
