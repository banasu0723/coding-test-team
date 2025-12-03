package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251203 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0 , 1, -1};
    static int r;
    static int c;
    static String[][] board;
    static boolean[][] visit;
    static int max = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        board = new String[r][c];
        visit = new boolean[r][c];


        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }

        dfs(0, 0, board[0][0],1);

        System.out.println(max);

    }


    static void dfs(int row, int col, String contains, int count) {

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                continue;
            }

            if (visit[nr][nc]) {
                continue;
            }

            if (contains.contains(board[nr][nc])) {
                continue;
            }

            visit[row][col] = true;
            dfs(nr, nc, contains + board[nr][nc], count + 1);
            visit[row][col] = false;
        }
        max = Math.max(count, max);
    }

}
