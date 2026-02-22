package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.StringTokenizer;

public class h_t_11 {

    static char[][] gr;
    static int r, c;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        gr = new char[r][c];
        visit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                gr[i][j] = s.charAt(j);
            }
        }


        visit[0][0] = true;
        dfs(0, 0, String.valueOf(gr[0][0]), 0);
        System.out.println(answer);

     }

    public static void dfs(int row, int col, String str, int v) {

        answer = Math.max(v + 1, answer);

        for (int i = 0; i < 4; i++) {

            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
            if (str.contains(String.valueOf(gr[nr][nc]))) continue;
            if (visit[nr][nc]) continue;
            visit[nr][nc] = true;
            dfs(nr, nc, str + gr[nr][nc], v + 1);
            visit[nr][nc] = false;

        }


    }
}
