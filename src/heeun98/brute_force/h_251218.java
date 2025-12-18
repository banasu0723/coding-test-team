package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_251218 {


    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int m;
    static int[][] numbers;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String read = br.readLine();
            st = new StringTokenizer(read);
            for (int j = 0; j < m; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, numbers[i][j]);
                visit[i][j] = false;
                checkT(i, j);
            }
        }


        System.out.println(result);


    }


    static void dfs(int row, int col, int count, int sum) {


        if (count == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            if (visit[nr][nc]) continue;

            visit[nr][nc] = true;
            dfs(nr, nc, count + 1, sum + numbers[nr][nc]);
            visit[nr][nc] = false;
        }

    }


    static void checkT(int r, int c) {
        int center = numbers[r][c];
        int sum = center;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            cnt++;
            sum += numbers[nr][nc];
            min = Math.min(min, numbers[nr][nc]);
        }

        // 주변이 3칸 이상이어야 T자 가능
        if (cnt >= 3) {
            // 4칸이면 가장 작은 값 하나 빼서 3개만 사용
            if (cnt == 4) sum -= min;
            result = Math.max(result, sum);
        }
    }
}
