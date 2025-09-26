package heeun98.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
 * 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
 * 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
 * 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
 * 두 배추의 위치가 같은 경우는 없다.
 * 2
 * 10 8 17
 * 0 0
 * 1 0
 * 1 1
 * 4 2
 * 4 3
 * 4 5
 * 2 4
 * 3 4
 * 7 4
 * 8 4
 * 9 4
 * 7 5
 * 8 5
 * 9 5
 * 7 6
 * 8 6
 * 9 6
 * 10 10 1
 * 5 5
 */
public class h_250926 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int m; // 필드는 기본값이 초기화
    public static int n; // 필드는 기본값이 초기화
    // 지역변수는 초기화 되지 않는다. 초기화 없이는 Null

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int contain = Integer.parseInt(st.nextToken());

            int[][] pos = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int j = 0; j < contain; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                pos[r][c] = 1;
            }

            int count = 0;
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < m; j++) {
                    if (pos[k][j] == 1 && !visit[k][j]) {
                        bfs(pos, visit, k, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void bfs(int[][] pos, boolean[][] visit, int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (pos[nr][nc] == 0) {
                    continue;
                }

                if (visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }

        }

    }
}
