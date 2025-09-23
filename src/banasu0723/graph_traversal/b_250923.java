package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2178 미로 탐색 bfs
public class b_250923 {
    static int n, m; // 행, 열
    static int[][] maze; // 미로 (0-벽, 1-길)
    static boolean[][] visited; // 방문 체크

    // 상, 하, 좌, 우 이동
    static int[] dx = {-1, 1, 0, 0}; // 행 방향: 위(-1), 아래(+1), 그대로(0), 그대로(0)
    static int[] dy = {0, 0, -1, 1}; //  열 방향: 그대로(0), 그대로(0), 왼쪽(-1), 오른쪽(+1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        // 미로 입력 (문자열 한 줄씩 읽어서 0/1로 변환)
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자 '1' → 정수 1, '0' → 정수 0
            }
        }

        System.out.println(bfs(0,0));

    }
    private static int bfs(int x, int y) {
        // 큐에는 [x좌표, y좌표, 현재까지 거리]를 저장
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1}); // 시작점 (0,0), 거리 1
        visited[x][y] = true;      // 시작점 방문 처리

        while (!q.isEmpty()) {     // 큐가 빌 때까지 반복
            int[] cur = q.poll();  // 현재 위치 꺼냄
            int cx = cur[0];       // 현재 x좌표
            int cy = cur[1];       // 현재 y좌표
            int dist = cur[2];     // 현재까지 거리

            // 도착점에 도달했을 경우 → 최단 거리 반환
            if (cx == n - 1 && cy == m - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 다음 x좌표
                int ny = cy + dy[i]; // 다음 y좌표

                // 범위 안에 있는지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 길(1)이고 아직 방문하지 않았다면
                    if (maze[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;         // 방문 체크
                        q.add(new int[]{nx, ny, dist + 1}); // 큐에 새로운 위치와 거리 추가
                    }
                }
            }
        }
        return -1; // 도착할 수 없는 경우 (문제 조건상 거의 없음)
    }
}
