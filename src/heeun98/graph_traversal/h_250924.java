package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_250924 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0 , 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                String[] split = input.split("");
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if (arr[nr][nc] == 0) continue;

                if (visit[nr][nc]) continue;;

                visit[nr][nc] = true;
                distance[nr][nc] = distance[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        System.out.println(distance[n - 1][m - 1] + 1);


    }
}
