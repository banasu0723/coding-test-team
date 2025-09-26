package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b_250925 {
    static int n;                       // 지도의 크기
    static int[][] map;                 // 지도 (0과 1로 구성)
    static boolean[][] visited;         // 방문 여부 체크
    static int count;                   // 현재 단지의 집 수 카운트

    // 상, 하, 좌, 우 이동 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 지도 크기 입력
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 정보 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0'; // '0' -> 0, '1' -> 1
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // 모든 좌표 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;   // 새로운 단지 발견하면 count 초기화
                    dfs(i, j);   // DFS 실행
                    result.add(count); // 단지 크기 저장
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(result);

        // 결과 출력
        System.out.println(result.size()); // 총 단지 수
        for (int num : result) {
            System.out.println(num); // 각 단지 크기
        }
    }

    // DFS 탐색
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위 벗어나지 않고, 집이 있고, 방문하지 않았을 경우
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
