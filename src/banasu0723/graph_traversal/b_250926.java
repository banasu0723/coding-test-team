package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_250926 {
    static int M, N, K;          // 가로, 세로, 배추 개수
    static int[][] field;        // 배추밭
    static boolean[][] visited;  // 방문 여부 체크

    // 상, 하, 좌, 우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이
            N = Integer.parseInt(st.nextToken()); // 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로
                int y = Integer.parseInt(st.nextToken()); // 세로
                field[y][x] = 1; // 좌표 주의! (y, x) 순서
            }

            int wormCount = 0; // 지렁이 개수

            // 밭 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++; // 새로운 군집 발견 시 지렁이 한 마리 필요
                    }
                }
            }

            sb.append(wormCount).append("\n");
        }

        System.out.print(sb);
    }

    // DFS 탐색
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 안에 있고, 배추가 있으며, 아직 방문 안 했다면
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
