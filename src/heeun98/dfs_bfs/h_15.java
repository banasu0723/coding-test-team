package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_15 {

    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int[] dr = {1, -1, 0, 0, 1, 1 , -1, -1};
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

                visit[i][j] = true;
                dfs(i, j);
                count++;
            }
        }

        System.out.println(count);

    }


    static void dfs(int r, int c) {

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                 continue;
            }
            if (arr[nr][nc] == 0) continue;
            if (visit[nr][nc]) continue;
            visit[nr][nc] = true;
            dfs(nr, nc);
        }

    }

}
