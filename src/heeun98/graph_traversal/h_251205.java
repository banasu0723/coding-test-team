package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_251205 {


    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int m;
    static int[][] gr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        gr = new int[n][m];
        visit = new boolean[n][m];


        for (int i = 0; i < k; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int sc = Integer.parseInt(st.nextToken());

            int sr = Integer.parseInt(st.nextToken());

            int nc = Integer.parseInt(st.nextToken());

            int nr = Integer.parseInt(st.nextToken());

            for (int y = sr; y < nr; y++) {
                for (int j = sc; j < nc; j++) {
                    gr[y][j] = 1;
                }
            }

        }

        int pos = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gr[i][j] == 0 && !visit[i][j]) {
                    int bfs = bfs(i, j);
                    result.add(bfs);
                    pos++;
                }
            }
        }

        Collections.sort(result);

        System.out.println(pos);
        System.out.println(result);

    }

    static int bfs(int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        visit[r][c] = true;
        queue.add(new int[]{r, c});
        int area = 1;


        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];


            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (visit[nr][nc]) {
                    continue;
                }
                if (gr[nr][nc] == 1) {
                    continue;
                }

                area++;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }


        return area;

    }
}
