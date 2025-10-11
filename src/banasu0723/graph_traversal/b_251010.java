package banasu0723.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724번 연결 요소의 개수
public class b_251010 {

    static int N, M; // 정점의 개수, 간선의 개수
    static int[][] graph; // 인접 행렬
    static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];   // 정점 번호가 1부터 시작하므로 +1
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 무방향 그래프 - 양쪽 연결
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int count = 0; // 연결 요소 개수

        // 모든 정점을 돌면서 방문하지 않았다면 새로운 연결 요소 시작
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++; // 한 번의 dfs가 끝나면 하나의 연결 요소 완성
            }
        }

        System.out.println(count);
    }

    // DFS
    private static void dfs(int v) {
        visited[v] = true; // 현재 노드 방문 처리

        for (int i = 1; i <= N; i++) {
            // 현재 정점 v와 i가 연결되어 있고, i를 아직 방문하지 않았다면 재귀 탐색
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }


    }
}
