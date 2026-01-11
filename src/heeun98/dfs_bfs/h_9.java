package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class h_9 {


    static int[][] arr;
    static boolean[][] visit;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[7][7];
        visit = new boolean[7][7];

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        visit[0][0] = true;
        dfs(0, 0);

        System.out.println(count);
    }




    static void dfs(int r, int c) {
        if (r == 6 && c == 6) {
            count++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= 7 || nc >= 7) continue;
            if (visit[nr][nc]) continue;
            if (arr[nr][nc] == 1) continue;

            visit[nr][nc] = true;
            dfs(nr, nc);
            visit[nr][nc] = false;

        }

    }


}
