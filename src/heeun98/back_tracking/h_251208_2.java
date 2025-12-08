package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class h_251208_2 {

    static boolean[][] visit;
    static int[][] table;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int m;
    static int area = 1;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        table = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < k; i++) {

            String input = br.readLine();
            st = new StringTokenizer(input);
            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());

            for (int j = startRow; j < endRow; j++) {
                for (int h = startCol; h < endCol; h++) {
                    table[j][h] = 1;
                }
            }
        }


        List<Integer> areas = new ArrayList<>();

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (table[i][j] == 0 && !visit[i][j]) {
                    area = 1;
                    visit[i][j] = true;
                    int area = dfs(i, j);
                    areas.add(area);
                    total++;
                }
            }
        }

        Collections.sort(areas);

        System.out.println(total);
        for (int i = 0; i < areas.size(); i++) {
            System.out.print(areas.get(i) + " ");
        }
    }


    static int dfs(int row, int col) {

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];


            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

            if (visit[nr][nc]) continue;

            if (table[nr][nc] == 1) continue;

            visit[nr][nc] = true;
            area++;
            dfs(nr, nc);
        }

        return area;
    }
}
